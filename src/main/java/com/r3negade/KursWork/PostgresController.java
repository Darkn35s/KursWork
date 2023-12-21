package com.r3negade.KursWork;

import com.r3negade.KursWork.Entities.*;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class PostgresController {

    private String str(String s){
        return "'"+s+"'";
    }
    private static PostgresController INSTANSE;
    private Connection conn;
    public static PostgresController GetINSTANSE(){
        if(INSTANSE!=null){
            return INSTANSE;
        }
        return new PostgresController();
    }

    private PostgresController()  {
        String url="jdbc:postgresql://localhost/KursWork";
        Properties props= new Properties();
        props.setProperty("user","postgres");
        props.setProperty("password","admin");
        props.setProperty("ssl","secret");
        try {
            this.conn= DriverManager.getConnection(url,props);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public List<Client> getClients(){
        Statement st = null;
        List<Client> client=new ArrayList<>();
        try {
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM client");
            while (rs.next()) {
               client.add(new Client(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4)));
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return client;
    }

    public void addClient(Client client){

        try {
            PreparedStatement st = conn.prepareStatement("INSERT INTO client ("+client.values+") VALUES ("+str(client.fio)+","+str(client.address)+","+str(client.phone)+")");
            st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


    public List<Materials> getMaterial(){
        Statement st = null;
        List<Materials> Materials=new ArrayList<>();
        try {
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM matstorage");
            while (rs.next()) {
                Materials.add(new Materials(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getInt(5)));
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return Materials;
    }

    public void addProdOrder(ProdOrder prodOrder){
        try {
            PreparedStatement st = conn.prepareStatement("INSERT INTO prodorder ("+prodOrder.values+") " +
                    "VALUES (" +
                    "'"+prodOrder.getDate()+"',"+
                    str(prodOrder.getMaterial())+","+
                    prodOrder.getMatCnt()+","+
                    prodOrder.getMatAmount()+","+
                    str(prodOrder.getDealer())+","+
                    str(prodOrder.getContAg())+","+
                    str(prodOrder.getManager())+","+
                    prodOrder.getContract()+","+
                    prodOrder.getNdc()+","+
                    prodOrder.getTotal()+
                    ")");
            st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<ProdOrder> getProdOrder(){
        Statement st = null;
        List<ProdOrder> orders=new ArrayList<>();
        try {
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM prodorder WHERE orderid not in (SELECT DISTINCT idorderprod from accounting)");
            while (rs.next()) {
                orders.add(new ProdOrder(rs.getInt(1),
                        rs.getDate(2).toLocalDate(),rs.getString(3),
                        rs.getInt(4),rs.getInt(5),
                        rs.getString(6),rs.getString(7),
                        rs.getString(8),rs.getInt(9),rs.getInt(10),rs.getInt(11)));
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return orders;
    }
    public List<ProdOrder> getProdOrder(int id){
        Statement st = null;
        List<ProdOrder> orders=new ArrayList<>();
        try {
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM prodorder WHERE orderid not in (SELECT DISTINCT idorderprod from accounting) AND orderid="+id);
            while (rs.next()) {
                orders.add(new ProdOrder(rs.getInt(1),
                        rs.getDate(2).toLocalDate(),rs.getString(3),
                        rs.getInt(4),rs.getInt(5),
                        rs.getString(6),rs.getString(7),
                        rs.getString(8),rs.getInt(9),rs.getInt(10),rs.getInt(11)));
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return orders;
    }

    public void addAccounting(Accounting accounting){
        try {
            PreparedStatement st = conn.prepareStatement("INSERT INTO accounting ("+accounting.value+") " +
                    "VALUES (" +
                    accounting.getIdOrderDev()+","+
                    accounting.getIdOrderProd()+","+
                    accounting.getAmount()+","+
                    "'"+accounting.getOrderdate()+"',"+
                    str(accounting.getDTacc())+","+
                    str(accounting.getKTacc())+
                    ")");
            st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void addDevOrder(DevOrder dev){
        try {
            PreparedStatement st = conn.prepareStatement("INSERT INTO developorder ("+dev.values+") " +
                    "VALUES (" +
                    dev.getClientId()+","+
                    "'"+dev.getOrderdate()+"',"+
                    str(dev.getOrderType())+","+
                    str(dev.getMaterial1())+","+
                    str(dev.getMaterial2())+","+
                    dev.getMaterial1cnt()+","+
                    dev.getMaterial2cnt()+","+
                    dev.isStatus()+","+
                    str(dev.getBrigadir())+
                    ")");
            st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<DevOrder> getDevOrder(){
        Statement st = null;
        List<DevOrder> orders=new ArrayList<>();
        try {
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM developorder WHERE not status");
            while (rs.next()) {
                orders.add(new DevOrder(rs.getInt(1),
                        rs.getInt(2),
                        rs.getDate(3).toLocalDate(),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7),
                        rs.getInt(8),
                        rs.getBoolean(9),
                        rs.getString(10)
                        ));
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return orders;


    }

    public void noticeDevOrder(int id){
        Statement st = null;
        List<DevOrder> orders=new ArrayList<>();
        try {
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM developorder WHERE not status and orderid="+id);
            while (rs.next()) {
                orders.add(new DevOrder(rs.getInt(1),
                        rs.getInt(2),
                        rs.getDate(3).toLocalDate(),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7),
                        rs.getInt(8),
                        rs.getBoolean(9),
                        rs.getString(10)
                ));
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        DevOrder dev= orders.get(0);
        addAccounting(new Accounting(dev.getOrderId(),
                dev.getMaterial1cnt()*120+dev.getMaterial2cnt()*115,
                dev.getOrderdate(),"20","10"));
        addAccounting(new Accounting(dev.getOrderId(),
                dev.getMaterial1cnt()*120+dev.getMaterial2cnt()*115,
                dev.getOrderdate(),"90","20"));
        try {
            PreparedStatement st2 = conn.prepareStatement("UPDATE developorder SET status=true WHERE orderid="+id);
            st2.executeUpdate();
            st2.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
