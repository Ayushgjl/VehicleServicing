package com.ayushgjl.vehicleservicing.Model;

public class CarBooking {

    private String name;
    private String contact;
    private String location;
    private String carnumber;
    private String problem;
    private String model;
    private String type;
    private String servicing;
    private String date;
    private String time;

    public CarBooking(String fullname, String contact, String location, String carnumber, String problem, String model, String type, String servicing, String date, String time) {
        this.name = fullname;
        this.contact = contact;
        this.location = location;
        this.carnumber = carnumber;
        this.problem = problem;
        this.model = model;
        this.type = type;
        this.servicing = servicing;
        this.date = date;
        this.time = time;
    }

    public String getFullname() {
        return name;
    }

    public void setFullname(String fullname) {
        this.name = fullname;
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

    public String getCarnumber() {
        return carnumber;
    }

    public void setCarnumber(String carnumber) {
        this.carnumber = carnumber;
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

    public String getServicing() {
        return servicing;
    }

    public void setServicing(String servicing) {
        this.servicing = servicing;
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
