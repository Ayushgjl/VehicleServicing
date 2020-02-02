package com.ayushgjl.vehicleservicing.Model;

public class User {
    private String firstname;
    private String lastname;
    private String PhoneNumber;
    private String username;
    private String password;
    private String image;

    public User(String firstname, String lastname, String phoneNumber, String username, String password, String image) {
        this.firstname = firstname;
        this.lastname = lastname;
        PhoneNumber = phoneNumber;
        this.username = username;
        this.password = password;
        this.image = image;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
