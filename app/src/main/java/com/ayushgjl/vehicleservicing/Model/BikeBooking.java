package com.ayushgjl.vehicleservicing.Model;

public class BikeBooking {

    private String name;
    private String contact;
    private String location;
    private String bikenumber;
    private String problem;
    private String model;
    private String type;
    private String date;
    private String time;

    public BikeBooking(String name, String contact, String location, String bikenumber, String problem, String model, String type, String date, String time) {
        this.name = name;
        this.contact = contact;
        this.location = location;
        this.bikenumber = bikenumber;
        this.problem = problem;
        this.model = model;
        this.type = type;
        this.date = date;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getBikenumber() {
        return bikenumber;
    }

    public void setBikenumber(String bikenumber) {
        this.bikenumber = bikenumber;
    }

    public String getProblem() {
        return problem;
    }

    public void setProblem(String problem) {
        this.problem = problem;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
