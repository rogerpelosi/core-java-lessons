package com.stackroute.model;

public class Salesrep {

    private int rep_id;
    private String name;
    private String city;
    private double commission;

    public Salesrep(int rep_id, String name, String city, double commission) {
        this.rep_id = rep_id;
        this.name = name;
        this.city = city;
        this.commission = commission;
    }

    public Salesrep(){}

    public int getRep_id() {
        return rep_id;
    }

    public void setRep_id(int rep_id) {
        this.rep_id = rep_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public double getCommission() {
        return commission;
    }

    public void setCommission(double commission) {
        this.commission = commission;
    }

    @Override
    public String toString() {
        return "Salesrep{" +
                "rep_id=" + rep_id +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", commision=" + commission +
                '}';
    }

}
