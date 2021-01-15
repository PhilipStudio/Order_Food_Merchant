package com.philip.studio.orderfoodmerchant.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.philip.studio.orderfoodmerchant.R;
import com.philip.studio.orderfoodmerchant.fragment.AccountFragment;
import com.philip.studio.orderfoodmerchant.fragment.CommentFragment;
import com.philip.studio.orderfoodmerchant.fragment.MenuFragment;
import com.philip.studio.orderfoodmerchant.fragment.OrderFragment;
import com.philip.studio.orderfoodmerchant.fragment.ReportFragment;

public class HomeActivity extends AppCompatActivity {

    BottomNavigationView bnvMenu;
    FrameLayout flContainer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_home);
        bnvMenu = findViewById(R.id.bottom_navigation_view);
        flContainer = findViewById(R.id.frame_layout_container);

        bnvMenu.setOnNavigationItemSelectedListener(listener);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frame_layout_container, new OrderFragment())
                .commit();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener listener = item -> {
        Fragment fragment = null;
        switch (item.getItemId()){
            case R.id.order:
                fragment = new OrderFragment();
                break;
            case R.id.report:
                fragment = new ReportFragment();
                break;
            case R.id.comment:
                fragment = new CommentFragment();
                break;
            case R.id.menu:
                fragment = new MenuFragment();
                break;
            case R.id.account:
                fragment = new AccountFragment();
                break;
        }
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout_container, fragment).commit();
        return true;
    };
}