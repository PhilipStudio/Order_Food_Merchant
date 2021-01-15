package com.philip.studio.orderfoodmerchant.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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
import com.philip.studio.orderfoodmerchant.adapter.OrderAdapter;
import com.philip.studio.orderfoodmerchant.model.Order;

import java.util.ArrayList;

public class OrderFragment extends Fragment {

    FirebaseDatabase firebaseDatabase;
    DatabaseReference dataRef;

    RecyclerView rVListOrder;

    ArrayList<Order> arrayList;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_order, container, false);
        initView(view);

        setUpRecyclerViewListOrder();
        return view;
    }

    private void setUpRecyclerViewListOrder(){
        rVListOrder.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        rVListOrder.setLayoutManager(layoutManager);

        dataRef.child("restaurant_01").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                    Order order = dataSnapshot.getValue(Order.class);
                    arrayList.add(order);
                }

                OrderAdapter adapter = new OrderAdapter(arrayList, getContext());
                rVListOrder.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void initView(View view){
        rVListOrder = view.findViewById(R.id.recycler_view_list_orders);

        arrayList = new ArrayList<>();

        firebaseDatabase = FirebaseDatabase.getInstance();
        dataRef = firebaseDatabase.getReference().child("Order").child("Merchant");
    }
}
