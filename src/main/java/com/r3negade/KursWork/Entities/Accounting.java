package com.r3negade.KursWork.Entities;

import java.time.LocalDate;

public class Accounting {
    public String value="idorderdev,idorderprod,amount,orderdate,dtacc,ktacc";
    int id;
    int idOrderDev;
    int idOrderProd;
    int amount;
    LocalDate orderdate;
    String DTacc;
    String KTacc;

    public Accounting() {
    }

    public Accounting(int idOrderDev,  int amount, LocalDate orderdate, String DTacc, String KTacc) {
        this.id = id;
        this.idOrderDev = idOrderDev;
        this.idOrderProd = idOrderProd;
        this.amount = amount;
        this.orderdate = orderdate;
        this.DTacc = DTacc;
        this.KTacc = KTacc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdOrderDev() {
        return idOrderDev;
    }

    public void setIdOrderDev(int idOrderDev) {
        this.idOrderDev = idOrderDev;
    }

    public int getIdOrderProd() {
        return idOrderProd;
    }

    public void setIdOrderProd(int idOrderProd) {
        this.idOrderProd = idOrderProd;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public LocalDate getOrderdate() {
        return orderdate;
    }

    public void setOrderdate(LocalDate orderdate) {
        this.orderdate = orderdate;
    }

    public String getDTacc() {
        return DTacc;
    }

    public void setDTacc(String DTacc) {
        this.DTacc = DTacc;
    }

    public String getKTacc() {
        return KTacc;
    }

    public void setKTacc(String KTacc) {
        this.KTacc = KTacc;
    }
}
