package com.philip.studio.orderfoodmerchant.fragment;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.philip.studio.orderfoodmerchant.R;
import com.philip.studio.orderfoodmerchant.model.Merchant;

public class SignUpFragment extends Fragment {

    ImageView imgBack;
    Button btnSignUp;
    EditText edtFirstname, edtLastname, edtEmail, edtPassword, edtAddress;

    FirebaseAuth firebaseAuth;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference dataMerchantRef;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sign_up, container, false);
        initView(view);

        imgBack.setOnClickListener(v -> getActivity().getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frame_layout_main, new HomeFragment())
                .commit());

        btnSignUp.setOnClickListener(v -> {
            String firstname = setDataInput(edtFirstname);
            String lastname = setDataInput(edtLastname);
            String address = setDataInput(edtAddress);
            String email = setDataInput(edtEmail);
            String password = setDataInput(edtPassword);

            firebaseAuth.createUserWithEmailAndPassword(email, password)
                    .addOnSuccessListener(authResult -> {
                        FirebaseUser firebaseUser = authResult.getUser();
                        if (firebaseUser != null) {
                            String idMerchant = firebaseUser.getUid();
                            Merchant merchant = new Merchant(idMerchant, email, password, firstname, lastname, address);
                            dataMerchantRef.child(idMerchant).setValue(merchant);
                        }
                    })
                    .addOnFailureListener(e -> Toast.makeText(getContext(), "Lỗi : " + e.getLocalizedMessage(), Toast.LENGTH_SHORT).show());
        });
        return view;
    }

    private String setDataInput(EditText editText) {
        String data = editText.getText().toString();
        if (TextUtils.isEmpty(data)) {
            editText.setError("Dữ liệu bị null");
        }
        return data;
    }

    private void initView(View view) {
        imgBack = view.findViewById(R.id.image_view_back);
        btnSignUp = view.findViewById(R.id.button_sign_up);
        edtFirstname = view.findViewById(R.id.edit_text_firstname);
        edtLastname = view.findViewById(R.id.edit_text_lastname);
        edtEmail = view.findViewById(R.id.edit_text_email);
        edtPassword = view.findViewById(R.id.edit_text_password);
        edtAddress = view.findViewById(R.id.edit_text_address);

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();
        dataMerchantRef = firebaseDatabase.getReference().child("Account").child("Merchant");
    }
}
