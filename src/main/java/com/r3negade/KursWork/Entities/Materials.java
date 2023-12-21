package com.r3negade.KursWork.Entities;

public class Materials {
    public int matId;
    public String name;
    public String type;
    public int cnt;
    public int price;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Materials(int matId, String name, String type, int cnt, int price) {
        this.matId = matId;
        this.name = name;
        this.type = type;
        this.cnt = cnt;
        this.price = price;
    }

    public Materials() {
    }

    public int getMatId() {
        return matId;
    }

    public void setMatId(int matId) {
        this.matId = matId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCnt() {
        return cnt;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }


}
