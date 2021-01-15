package com.philip.studio.orderfoodmerchant.model;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class Food {
    private String idProduct;
    private String name, image;
    private double like, price;

    public Food() {
    }

    public Food(String idProduct, String name, String image, double like, double price) {
        this.idProduct = idProduct;
        this.name = name;
        this.image = image;
        this.like = like;
        this.price = price;
    }

    public String getIdProduct() {
        return idProduct;
    }

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }

    public double getLike() {
        return like;
    }

    public double getPrice() {
        return price;
    }
}
