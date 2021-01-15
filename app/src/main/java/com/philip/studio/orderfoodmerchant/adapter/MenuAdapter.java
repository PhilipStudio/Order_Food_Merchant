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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.philip.studio.orderfoodmerchant.R;
import com.philip.studio.orderfoodmerchant.model.Food;
import com.philip.studio.orderfoodmerchant.model.Menu;

import java.util.ArrayList;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.ViewHolder> {

    ArrayList<Menu> arrayList;
    Context context;

    public MenuAdapter(ArrayList<Menu> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_menu, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txtNameMenu.setText(arrayList.get(position).getName());
        holder.rVListFoods.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(context, RecyclerView.HORIZONTAL, false);
        holder.rVListFoods.setLayoutManager(layoutManager);

        ListFoodAdapter adapter = new ListFoodAdapter(arrayList.get(position).getFoods(), context);
        holder.rVListFoods.setAdapter(adapter);
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView txtNameMenu;
        RecyclerView rVListFoods;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtNameMenu = itemView.findViewById(R.id.item_name_menu);
            rVListFoods = itemView.findViewById(R.id.item_recycler_view_list_foods);
        }
    }
}
