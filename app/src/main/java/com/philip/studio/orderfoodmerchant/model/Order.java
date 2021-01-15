package com.philip.studio.orderfoodmerchant.model;

import com.google.firebase.database.IgnoreExtraProperties;

import java.util.ArrayList;

@IgnoreExtraProperties
public class Order {
    private String idOrder;
    private String idRes;
    private String paymentId;
    private String phone;
    private String name;
    private String address;
    private String total;
    private ArrayList<Food> arrayList;
    private String status;

    public Order() {
    }

    public Order(String idOrder, String idRes, String paymentId, String phone, String name, String address, String total, ArrayList<Food> arrayList, String status) {
        this.idOrder = idOrder;
        this.idRes = idRes;
        this.paymentId = paymentId;
        this.phone = phone;
        this.name = name;
        this.address = address;
        this.total = total;
        this.arrayList = arrayList;
        this.status = status;
    }

    public String getIdOrder() {
        return idOrder;
    }

    public String getIdRes() {
        return idRes;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public String getPhone() {
        return phone;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getTotal() {
        return total;
    }

    public ArrayList<Food> getArrayList() {
        return arrayList;
    }

    public String getStatus() {
        return status;
    }
}
