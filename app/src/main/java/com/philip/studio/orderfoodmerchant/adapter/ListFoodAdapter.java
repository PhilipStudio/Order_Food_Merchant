package com.philip.studio.orderfoodmerchant.adapter;/*
//
// Project: Order Food Merchant
// Created by ViettelStore on 1/14/2021.
// Copyright © 2021-2022 Philip Studio. All rights reserved.
//
*/

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.philip.studio.orderfoodmerchant.R;
import com.philip.studio.orderfoodmerchant.model.Food;

import java.util.ArrayList;

public class ListFoodAdapter extends RecyclerView.Adapter<ListFoodAdapter.ViewHolder> {

    ArrayList<Food> arrayList;
    Context context;

    public ListFoodAdapter(ArrayList<Food> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_food, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Glide.with(context).load(arrayList.get(position).getImage()).into(holder.imgImage);
        holder.txtNameFood.setText(arrayList.get(position).getName());
        holder.txtPriceFood.setText(String.valueOf(arrayList.get(position).getPrice()));
        holder.txtLikeFood.setText(String.valueOf(arrayList.get(position).getLike()));
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView imgImage;
        TextView txtNameFood, txtPriceFood, txtLikeFood;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imgImage = itemView.findViewById(R.id.item_image_food);
            txtNameFood = itemView.findViewById(R.id.item_name_food);
            txtPriceFood = itemView.findViewById(R.id.item_price_food);
            txtLikeFood = itemView.findViewById(R.id.item_like_food);
        }
    }
}
