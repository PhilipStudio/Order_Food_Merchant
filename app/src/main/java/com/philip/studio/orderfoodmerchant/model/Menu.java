package com.philip.studio.orderfoodmerchant.model;/*
//
// Project: Order Food Merchant
// Created by ViettelStore on 1/14/2021.
// Copyright © 2021-2022 Philip Studio. All rights reserved.
//
*/

import com.google.firebase.database.IgnoreExtraProperties;

import java.util.ArrayList;

@IgnoreExtraProperties
public class Menu {
    private String idMenu;
    private String name;
    private ArrayList<Food> foods;

    public Menu(){}

    public String getIdMenu() {
        return idMenu;
    }

    public ArrayList<Food> getFoods() {
        return foods;
    }

    public String getName() {
        return name;
    }
}