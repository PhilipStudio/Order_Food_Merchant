package com.philip.studio.orderfoodmerchant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;

import com.philip.studio.orderfoodmerchant.activity.HomeActivity;
import com.philip.studio.orderfoodmerchant.fragment.HomeFragment;
import com.philip.studio.orderfoodmerchant.util.MerchantUtil;

public class MainActivity extends AppCompatActivity {

    FrameLayout fLMain;

    MerchantUtil util;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        fLMain = findViewById(R.id.frame_layout_main);

        util = new MerchantUtil(this);
        if (util.getMerchantUtil() != null) {
            Intent intent = new Intent(this, HomeActivity.class);
            startActivity(intent);
        } else {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frame_layout_main, new HomeFragment())
                    .commit();
        }
    }
}