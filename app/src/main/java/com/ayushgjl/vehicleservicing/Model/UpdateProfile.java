package com.ayushgjl.vehicleservicing.Model;

import java.io.Serializable;

public class UpdateProfile implements Serializable {
    private String firstName;
    private String lastName;
    private String phonenumber;
    private String username;
    private String image;

    public UpdateProfile(String firstName, String lastName, String phonenumber, String username, String image) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phonenumber = phonenumber;
        this.username = username;
        this.image = image;

    }
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
