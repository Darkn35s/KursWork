package com.r3negade.KursWork.Entities;

import java.time.LocalDate;

public class DevOrder {
    public String values="clientid,orderdate,ordertype,material1,material2,material1cnt,material2cnt,status,brigadir";
    int orderId;
    int clientId;
    LocalDate orderdate;
    String orderType;
    String material1;
    String material2;
    int material1cnt;
    int material2cnt;
    boolean status = false;
    String brigadir;

    public DevOrder() {
    }

    public DevOrder(int orderId, int clientId, LocalDate orderdate, String orderType, String material1, String material2, int material1cnt, int material2cnt, boolean status, String brigadir) {
        this.orderId = orderId;
        this.clientId = clientId;
        this.orderdate = orderdate;
        this.orderType = orderType;
        this.material1 = material1;
        this.material2 = material2;
        this.material1cnt = material1cnt;
        this.material2cnt = material2cnt;
        this.status = status;
        this.brigadir = brigadir;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public LocalDate getOrderdate() {
        return orderdate;
    }

    public void setOrderdate(LocalDate orderdate) {
        this.orderdate = orderdate;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getMaterial1() {
        return material1;
    }

    public void setMaterial1(String material1) {
        this.material1 = material1;
    }

    public String getMaterial2() {
        return material2;
    }

    public void setMaterial2(String material2) {
        this.material2 = material2;
    }

    public int getMaterial1cnt() {
        return material1cnt;
    }

    public void setMaterial1cnt(int material1cnt) {
        this.material1cnt = material1cnt;
    }

    public int getMaterial2cnt() {
        return material2cnt;
    }

    public void setMaterial2cnt(int material2cnt) {
        this.material2cnt = material2cnt;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getBrigadir() {
        return brigadir;
    }

    public void setBrigadir(String brigadir) {
        this.brigadir = brigadir;
    }
}
