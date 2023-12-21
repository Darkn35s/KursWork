package com.r3negade.KursWork.Entities;

import java.time.LocalDate;

public class ProdOrder {
    public String values = "orderdate, material,materialcnt,materialamount,dealer,contragent,manager,contract,ndc,total";
    int orderId;
    LocalDate date;
    String material;
    int matCnt;
    int matAmount;
    String dealer;
    String contAg;
    String manager;
    int contract;
    int ndc;
    int total;

    public ProdOrder(int orderId, LocalDate date, String material, int matCnt, int matAmount, String dealer, String contAg, String manager, int contract, int ndc, int total) {
        this.orderId = orderId;
        this.date = date;
        this.material = material;
        this.matCnt = matCnt;
        this.matAmount = matAmount;
        this.dealer = dealer;
        this.contAg = contAg;
        this.manager = manager;
        this.contract = contract;
        this.ndc = ndc;
        this.total = total;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public int getMatCnt() {
        return matCnt;
    }

    public void setMatCnt(int matCnt) {
        this.matCnt = matCnt;
    }

    public int getMatAmount() {
        return matAmount;
    }

    public void setMatAmount(int matAmount) {
        this.matAmount = matAmount;
    }

    public String getDealer() {
        return dealer;
    }

    public void setDealer(String dealer) {
        this.dealer = dealer;
    }

    public String getContAg() {
        return contAg;
    }

    public void setContAg(String contAg) {
        this.contAg = contAg;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public int getContract() {
        return contract;
    }

    public void setContract(int contract) {
        this.contract = contract;
    }

    public int getNdc() {
        return ndc;
    }

    public void setNdc(int ndc) {
        this.ndc = ndc;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public ProdOrder() {
    }
}
