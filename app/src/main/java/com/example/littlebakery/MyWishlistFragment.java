package com.example.littlebakery;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class MyWishlistFragment extends Fragment {

    public MyWishlistFragment() {
        // Required empty public constructor
    }

    private RecyclerView wishlistRecyclerview;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_my_wishlist, container, false);

        wishlistRecyclerview = view.findViewById(R.id.my_wishlist_recyclerview);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        wishlistRecyclerview.setLayoutManager(linearLayoutManager);

        List<WishlistModel> wishlistModelList = new ArrayList<>();
        wishlistModelList.add(new WishlistModel(R.drawable.cake7,"Vanilla Cake","Rs.450/-","Rs.500/-","Cash on delivery"));
        wishlistModelList.add(new WishlistModel(R.drawable.cake4,"Choco Vanilla Cake","Rs.550/-","Rs.600/-","Cash on delivery"));
        wishlistModelList.add(new WishlistModel(R.drawable.cake2,"Vanilla Cake","Rs.300/-","Rs.400/-","Cash on delivery"));
        wishlistModelList.add(new WishlistModel(R.drawable.cake1,"Chocolate Cake","Rs.600/-","Rs.650/-","Cash on delivery"));

        WishlistAdapter wishlistAdapter = new WishlistAdapter(wishlistModelList);
        wishlistRecyclerview.setAdapter(wishlistAdapter);
        wishlistAdapter.notifyDataSetChanged();

        return view;
    }
}