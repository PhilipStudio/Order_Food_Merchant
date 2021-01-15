package com.philip.studio.orderfoodmerchant.model;/*
//
// Project: Order Food Merchant
// Created by ViettelStore on 1/14/2021.
// Copyright © 2021-2022 Philip Studio. All rights reserved.
//
*/

import com.google.firebase.database.IgnoreExtraProperties;

import java.io.Serializable;

@IgnoreExtraProperties
public class Promotion implements Serializable {
    int isPromotion;
    String content;
    double discount;
    int typePromotion;

    public Promotion() {
    }

    public Promotion(int isPromotion, String content, double discount, int typePromotion) {
        this.isPromotion = isPromotion;
        this.content = content;
        this.discount = discount;
        this.typePromotion = typePromotion;
    }



    public int getIsPromotion() {
        return isPromotion;
    }

    public String getContent() {
        return content;
    }

    public double getDiscount() {
        return discount;
    }

    public int getTypePromotion() {
        return typePromotion;
    }
}
