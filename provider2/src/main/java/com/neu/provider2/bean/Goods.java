package com.neu.provider2.bean;

public class Goods {
    private int id;
    private String name;
    private int f_id;
    private double price;

    private String instanceId = "Provider II";

    public String getInstanceId() {
        return instanceId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getF_id() {
        return f_id;
    }

    public void setF_id(int f_id) {
        this.f_id = f_id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
