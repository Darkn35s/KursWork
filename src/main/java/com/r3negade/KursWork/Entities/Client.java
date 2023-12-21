package com.r3negade.KursWork.Entities;

public class Client {
    public String values="fio, address, phone";
    public int clientId;
    public String fio;
    public String address;
    public String phone;

    public Client(int clientId, String fio, String address, String phone) {
        this.clientId = clientId;
        this.fio = fio;
        this.address = address;
        this.phone = phone;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Client() {
    }



}
