package com.philip.studio.orderfoodmerchant.model;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class Merchant {
    private String idMerchant;
    private String email;
    private String password;
    private String firstname;
    private String lastname;
    private String address;

    public Merchant() {
    }

    public Merchant(String idMerchant, String email, String password, String firstname, String lastname, String address) {
        this.idMerchant = idMerchant;
        this.email = email;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
    }

    public String getIdMerchant() {
        return idMerchant;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getAddress() {
        return address;
    }

    public void setIdMerchant(String idMerchant) {
        this.idMerchant = idMerchant;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
