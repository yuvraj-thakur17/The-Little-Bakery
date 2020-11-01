package com.example.littlebakery;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class GridProductLayoutAdapter extends RecyclerView.Adapter<GridProductLayoutAdapter.MyViewHolder> {

    private Context context;
    private LayoutInflater layoutInflater;
    private List<Horizontal_Product_Scroll_Model> horizontalProductScrollModelList = new ArrayList<>();

    public GridProductLayoutAdapter(Context context) {
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }

    public void setHorizontalProductScrollModelList(List<Horizontal_Product_Scroll_Model> horizontalProductScrollModelList) {
        this.horizontalProductScrollModelList = horizontalProductScrollModelList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.grid_produt_layout_for_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Horizontal_Product_Scroll_Model data = horizontalProductScrollModelList.get(position);
        holder.productImage.setImageResource(data.getProductImage());
        holder.productTitle.setText(data.getProductName());
        holder.productPrice.setText(data.getProductPrice());
        holder.cuttedPrice.setText(data.getCuttedPrice());
        holder.clProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent productDetailsIntent = new Intent(context,ProductDetailsActivity.class);
                context.startActivity(productDetailsIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return horizontalProductScrollModelList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        private ImageView productImage;
        private TextView productTitle;
        private TextView productPrice;
        private TextView cuttedPrice;
        private ConstraintLayout clProduct;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            productImage = itemView.findViewById(R.id.product_image_grid);
            productTitle = itemView.findViewById(R.id.product_title_grid);
            productPrice = itemView.findViewById(R.id.product_price_grid);
            cuttedPrice = itemView.findViewById(R.id.cutted_price_grid);
            clProduct = itemView.findViewById(R.id.cl_product);
        }
    }
}
