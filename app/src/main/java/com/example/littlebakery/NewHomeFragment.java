package com.example.littlebakery;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

public class NewHomeFragment extends Fragment {

    public NewHomeFragment(){
    }

//    private GridView gridView;
    private RecyclerView rlProducts;
    private GridProductLayoutAdapter gridProductLayoutAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_new_home, container, false);
        rlProducts = view.findViewById(R.id.rl_products);
//        gridView = view.findViewById(R.id.home_gridView);

        List<Horizontal_Product_Scroll_Model> horizontal_product_scroll_modelList = new ArrayList<>();
        horizontal_product_scroll_modelList.add(new Horizontal_Product_Scroll_Model(R.drawable.cake20,"Chocolate Cake","Rs.550/-","Rs.700/-"));
        horizontal_product_scroll_modelList.add(new Horizontal_Product_Scroll_Model(R.drawable.bakery2,"Strawberry  Cake","Rs.400/-","Rs.500/-"));
        horizontal_product_scroll_modelList.add(new Horizontal_Product_Scroll_Model(R.drawable.cake1,"Choco Vanilla Cake","Rs.450/-","Rs.500/-"));
        horizontal_product_scroll_modelList.add(new Horizontal_Product_Scroll_Model(R.drawable.cake4,"Chocolate Truffle Cake","Rs.600/-","Rs.650/-"));
        horizontal_product_scroll_modelList.add(new Horizontal_Product_Scroll_Model(R.drawable.cake5,"Butterscotch Cake","Rs.550/-","Rs.600/-"));
        horizontal_product_scroll_modelList.add(new Horizontal_Product_Scroll_Model(R.drawable.cake6,"Vanilla Strawberry  Cake","Rs.600/-","Rs.650/-"));
        horizontal_product_scroll_modelList.add(new Horizontal_Product_Scroll_Model(R.drawable.cake7,"Choco Chip Cake","Rs.450/-","Rs.550/-"));
        horizontal_product_scroll_modelList.add(new Horizontal_Product_Scroll_Model(R.drawable.cake10,"Red Velvet Cake","Rs.400/-","Rs.450/-"));
        horizontal_product_scroll_modelList.add(new Horizontal_Product_Scroll_Model(R.drawable.cake20,"Chocolate Cake","Rs.550/-","Rs.700/-"));
        horizontal_product_scroll_modelList.add(new Horizontal_Product_Scroll_Model(R.drawable.bakery2,"Strawberry Cake","Rs.400/-","Rs.500/-"));
        horizontal_product_scroll_modelList.add(new Horizontal_Product_Scroll_Model(R.drawable.cake1,"Choco Vanilla Cake","Rs.450/-","Rs.500/-"));
        horizontal_product_scroll_modelList.add(new Horizontal_Product_Scroll_Model(R.drawable.cake4,"Chocolate Truffle Cake","Rs.600/-","Rs.650/-"));
        horizontal_product_scroll_modelList.add(new Horizontal_Product_Scroll_Model(R.drawable.cake5,"Butterscotch Cake","Rs.550/-","Rs.600/-"));
        horizontal_product_scroll_modelList.add(new Horizontal_Product_Scroll_Model(R.drawable.cake6,"Vanilla Strawberry Cake","Rs.550/-","Rs.600/-"));
        horizontal_product_scroll_modelList.add(new Horizontal_Product_Scroll_Model(R.drawable.cake7,"Choco Chip Cake","Rs.550/-","Rs.600/-"));
        horizontal_product_scroll_modelList.add(new Horizontal_Product_Scroll_Model(R.drawable.cake10,"Red Velvet Cake","Rs.550/-","Rs.600/-"));

        gridProductLayoutAdapter = new GridProductLayoutAdapter(getContext());
        rlProducts.setLayoutManager(new GridLayoutManager(getContext(), 2));
        rlProducts.setAdapter(gridProductLayoutAdapter);
        gridProductLayoutAdapter.setHorizontalProductScrollModelList(horizontal_product_scroll_modelList);
        gridProductLayoutAdapter.notifyDataSetChanged();

//        Grid_Product_Layout_Adapter grid_product_layout_adapter = new Grid_Product_Layout_Adapter(horizontal_product_scroll_modelList);
//        gridView.setAdapter(grid_product_layout_adapter);

        return view;
    }
}