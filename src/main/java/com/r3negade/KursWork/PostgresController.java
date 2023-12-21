package com.r3negade.KursWork;

import com.r3negade.KursWork.Entities.Client;
import com.r3negade.KursWork.Entities.Materials;
import com.r3negade.KursWork.Entities.ProdOrder;

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


}
