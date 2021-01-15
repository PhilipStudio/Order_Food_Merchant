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
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.philip.studio.orderfoodmerchant.R;
import com.philip.studio.orderfoodmerchant.model.Order;

import java.util.ArrayList;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.ViewHolder> {

    ArrayList<Order> arrayList;
    Context context;

    public OrderAdapter(ArrayList<Order> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_order, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txtOrderTotal.setText(arrayList.get(position).getTotal());
        holder.txtOrderInfo.setText(arrayList.get(position).getArrayList().size() + " item ordered");
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView txtOrderInfo, txtOrderTotal;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtOrderInfo = itemView.findViewById(R.id.item_order_info);
            txtOrderTotal = itemView.findViewById(R.id.item_order_total);
        }
    }
}
