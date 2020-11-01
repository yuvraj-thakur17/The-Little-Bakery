package com.example.littlebakery;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Grid_Product_Layout_Adapter extends BaseAdapter {

    List<Horizontal_Product_Scroll_Model> horizontal_product_scroll_modelList;

    public Grid_Product_Layout_Adapter(List<Horizontal_Product_Scroll_Model> horizontal_product_scroll_modelList) {
        this.horizontal_product_scroll_modelList = horizontal_product_scroll_modelList;
    }

    public Grid_Product_Layout_Adapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup,int i){
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.grid_produt_layout_for_item,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public int getCount() {
        return horizontal_product_scroll_modelList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        if (convertView == null){
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_produt_layout_for_item,null);
            ImageView productImage = view.findViewById(R.id.product_image_grid);
            TextView productTitle = view.findViewById(R.id.product_title_grid);
            TextView productPrice = view.findViewById(R.id.product_price_grid);
            TextView cuttedPrice = view.findViewById(R.id.cutted_price_grid);

            productImage.setImageResource(horizontal_product_scroll_modelList.get(position).getProductImage());
            productTitle.setText(horizontal_product_scroll_modelList.get(position).getProductName());
            productPrice.setText(horizontal_product_scroll_modelList.get(position).getProductPrice());
            cuttedPrice.setText(horizontal_product_scroll_modelList.get(position).getCuttedPrice());

        }
        else {
            view = convertView;
        }
        return view;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView productImage;
        private TextView productTitle;
        private TextView productPrice;
        private TextView cuttedPrice;
        private ConstraintLayout clProduct;

        public ViewHolder(final View itemView) {
            super(itemView);
            productImage = itemView.findViewById(R.id.product_image_grid);
            productTitle = itemView.findViewById(R.id.product_title_grid);
            productPrice = itemView.findViewById(R.id.product_price_grid);
            cuttedPrice = itemView.findViewById(R.id.cutted_price_grid);
            clProduct = itemView.findViewById(R.id.cl_product);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent productDetailsIntent = new Intent(itemView.getContext(),ProductDetailsActivity.class);
                    itemView.getContext().startActivity(productDetailsIntent);
                }
            });

        }


        private void setProductImage(int resource) { productImage.setImageResource(resource);}

        private void setProductTitle(String title) { productTitle.setText(title);}

        private void setProductPrice(String price) { productPrice.setText(price);}

        private void setCuttedPrice(String cut) { cuttedPrice.setText(cut);}
    }

}
