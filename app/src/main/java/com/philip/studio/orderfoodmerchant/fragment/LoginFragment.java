package com.philip.studio.orderfoodmerchant.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.philip.studio.orderfoodmerchant.activity.HomeActivity;
import com.philip.studio.orderfoodmerchant.R;
import com.philip.studio.orderfoodmerchant.model.Merchant;
import com.philip.studio.orderfoodmerchant.util.MerchantUtil;

public class LoginFragment extends Fragment {

    ImageView imgBack;
    EditText edtEmail, edtPassword;
    Switch aSwitchRemember;
    Button btnLogin;

    boolean isRememberMe = false;
    MerchantUtil merchantUtil;
    FirebaseAuth firebaseAuth;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference dataMerchantRef;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        initView(view);

        if (merchantUtil.getMerchantUtil() != null){
            edtEmail.setText(merchantUtil.getMerchantUtil().getEmail());
            edtPassword.setText(merchantUtil.getMerchantUtil().getPassword());
        }

        imgBack.setOnClickListener(v -> getActivity().getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frame_layout_main, new HomeFragment())
                .commit());

        aSwitchRemember.setOnCheckedChangeListener((buttonView, isChecked) -> {
            aSwitchRemember.setChecked(true);
            if (isChecked) {
                isRememberMe = true;
            }
        });

        btnLogin.setOnClickListener(v -> {
            String email = edtEmail.getText().toString();
            String password = edtPassword.getText().toString();

            if (TextUtils.isEmpty(email) || TextUtils.isEmpty(password)) {
                Toast.makeText(getContext(), "Ban cần nhập đầy đủ dữ liệu", Toast.LENGTH_SHORT).show();
            } else {
                firebaseAuth.signInWithEmailAndPassword(email, password)
                        .addOnSuccessListener(authResult -> {
                            FirebaseUser firebaseUser = authResult.getUser();
                            if (firebaseUser != null) {
                                String idMerchant = firebaseUser.getUid();
                                if (isRememberMe) {
                                    getAccountMerchant(idMerchant);
                                } else {
                                    Intent intent = new Intent(getContext(), HomeActivity.class);
                                    startActivity(intent);
                                    getActivity().finish();
                                }
                            }
                        })
                        .addOnFailureListener(e -> Toast.makeText(getContext(), "Lỗi đăng nhập: " + e.getLocalizedMessage(), Toast.LENGTH_SHORT).show());
            }
        });

        return view;
    }

    private void getAccountMerchant(String id) {
        dataMerchantRef.child(id).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Merchant merchant = snapshot.getValue(Merchant.class);
                if (merchant != null) {
                    merchantUtil.setMerchantUtil(merchant);
                    Intent intent = new Intent(getContext(), HomeActivity.class);
                    startActivity(intent);
                    getActivity().finish();
                }
                else{
                    Toast.makeText(getContext(), "Tài khoản không tồn tại", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initView(View view) {
        imgBack = view.findViewById(R.id.image_view_back);
        edtEmail = view.findViewById(R.id.edit_text_email);
        edtPassword = view.findViewById(R.id.edit_text_password);
        aSwitchRemember = view.findViewById(R.id.switch_remember);
        btnLogin = view.findViewById(R.id.button_login);

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();
        dataMerchantRef = firebaseDatabase.getReference().child("Account").child("Merchant");
        merchantUtil = new MerchantUtil(getContext());
    }
}
