package com.philip.studio.orderfoodmerchant.util;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.philip.studio.orderfoodmerchant.model.Merchant;

public class MerchantUtil {
    private SharedPreferences preferences;

    public MerchantUtil(Context context){
        preferences = context.getSharedPreferences("merchant", Context.MODE_PRIVATE);
    }

    public void setMerchantUtil(Merchant data){
        SharedPreferences.Editor editor = preferences.edit();
        Gson gson = new Gson();
        String merchant = gson.toJson(data);
        editor.putString("merchant", merchant);
    }

    public Merchant getMerchantUtil(){
        String data = preferences.getString("merchant", null);
        Gson gson = new Gson();
        return gson.fromJson(data, Merchant.class);
    }
}
