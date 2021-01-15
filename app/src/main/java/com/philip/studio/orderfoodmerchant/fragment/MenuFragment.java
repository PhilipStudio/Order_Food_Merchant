package com.philip.studio.orderfoodmerchant.fragment;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.philip.studio.orderfoodmerchant.R;
import com.philip.studio.orderfoodmerchant.adapter.ListFoodAdapter;
import com.philip.studio.orderfoodmerchant.adapter.MenuAdapter;
import com.philip.studio.orderfoodmerchant.model.Food;
import com.philip.studio.orderfoodmerchant.model.Menu;

import java.util.ArrayList;

public class MenuFragment extends Fragment {

    RecyclerView rVListMenu;
    Button btnAddFood;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference dataMenuRef;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_menu, container, false);
        initView(view);

        dataMenuRef.child("restaurant_01").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                ArrayList<Menu> arrayList = new ArrayList<>();
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    Menu menu = dataSnapshot.getValue(Menu.class);
                    arrayList.add(menu);
                }

                loadListMenu(arrayList);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        btnAddFood.setOnClickListener(v -> showDialogAddFood());

        return view;
    }

    private void loadListMenu(ArrayList<Menu> arrayList) {
        rVListMenu.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        rVListMenu.setLayoutManager(layoutManager);

        MenuAdapter adapter = new MenuAdapter(arrayList, getContext());
        rVListMenu.setAdapter(adapter);
    }

    private void showDialogAddFood(){
        Dialog dialog = new Dialog(getContext());
        dialog.setContentView(R.layout.layout_dialog_add_food);

        dialog.show();
    }

    private void initView(View view) {
        btnAddFood = view.findViewById(R.id.button_add_food);
        rVListMenu = view.findViewById(R.id.recycler_view_list_menu);

        firebaseDatabase = FirebaseDatabase.getInstance();
        dataMenuRef = firebaseDatabase.getReference().child("Menu");
    }
}
