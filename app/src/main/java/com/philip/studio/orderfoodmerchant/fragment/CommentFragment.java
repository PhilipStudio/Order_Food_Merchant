package com.philip.studio.orderfoodmerchant.fragment;/*
//
// Project: Order Food Merchant
// Created by ViettelStore on 1/14/2021.
// Copyright © 2021-2022 Philip Studio. All rights reserved.
//
*/

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.philip.studio.orderfoodmerchant.R;

public class CommentFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_comment, container, false);
        return view;
    }
}
