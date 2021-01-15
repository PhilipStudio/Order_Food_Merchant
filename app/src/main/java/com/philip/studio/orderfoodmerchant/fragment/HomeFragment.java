package com.philip.studio.orderfoodmerchant.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.philip.studio.orderfoodmerchant.R;

public class HomeFragment extends Fragment {

    Button btnSignUpFacebook, btnSignUpEmail;
    TextView txtLogin;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        initView(view);

        txtLogin.setOnClickListener(v -> getActivity().getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frame_layout_main, new LoginFragment())
                .commit());

        btnSignUpEmail.setOnClickListener(v -> getActivity().getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frame_layout_main, new SignUpFragment())
                .commit());

        return view;
    }

    private void initView(View view){
        btnSignUpEmail = view.findViewById(R.id.button_sign_up_email);
        btnSignUpFacebook = view.findViewById(R.id.button_sign_up_facebook);
        txtLogin = view.findViewById(R.id.text_view_login);
    }
}
