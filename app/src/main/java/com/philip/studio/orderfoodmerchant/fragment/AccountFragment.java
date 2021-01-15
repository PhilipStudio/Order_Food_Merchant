package com.philip.studio.orderfoodmerchant.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.philip.studio.orderfoodmerchant.MainActivity;
import com.philip.studio.orderfoodmerchant.R;
import com.philip.studio.orderfoodmerchant.util.MerchantUtil;

public class AccountFragment extends Fragment {

    Button btnSignOut;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference dataAccountRef;

    MerchantUtil util;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_account, container, false);
        initView(view);

        btnSignOut.setOnClickListener(v -> {
            Intent intent = new Intent(getContext(), MainActivity.class);
            startActivity(intent);
        });



        return view;
    }

    private void displayInformationAccountMerchant(){

    }

    private void initView(View view) {
        btnSignOut = view.findViewById(R.id.button_sign_out);
        firebaseDatabase = FirebaseDatabase.getInstance();
        dataAccountRef= firebaseDatabase.getReference().child("Account").child("Merchant");
        util = new MerchantUtil(getContext());
    }
}
