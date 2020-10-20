package com.example.littlebakery;

import android.content.res.ColorStateList;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyOrderAdapter extends RecyclerView.Adapter<MyOrderAdapter.Viewholder> {

    private List<MyOrderItemModel> myOrderItemModelList;

    public MyOrderAdapter(List<MyOrderItemModel> myOrderItemModelList) {
        this.myOrderItemModelList = myOrderItemModelList;
    }

    @NonNull
    @Override
    public MyOrderAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.my_orders_item_layout,viewGroup,false);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyOrderAdapter.Viewholder viewholder, int position) {
        int resource = myOrderItemModelList.get(position).getProductImage();
        String title = myOrderItemModelList.get(position).getProductTitle();
        String deliveredDate = myOrderItemModelList.get(position).getDeliveryStatus();
        viewholder.setData(resource,title,deliveredDate);
    }

    @Override
    public int getItemCount() {
        return myOrderItemModelList.size();
    }

    class Viewholder extends RecyclerView.ViewHolder{

        private ImageView productImage;
        private ImageView orderIndicator;
        private TextView productTitle;
        private TextView deliveryStatus;

        public Viewholder(@NonNull View itemView) {
            super(itemView);
            productImage = itemView.findViewById(R.id.product_image);
            productTitle = itemView.findViewById(R.id.product_title);
            orderIndicator = itemView.findViewById(R.id.order_indicator);
            deliveryStatus = itemView.findViewById(R.id.order_delivered_date);
        }
        private void setData(int resource, String title, String deliveredDate){
            productImage.setImageResource(resource);
            productTitle.setText(title);
            if (deliveredDate.equals("Cancelled")){
                orderIndicator.setImageTintList(ColorStateList.valueOf(itemView.getContext().getResources().getColor(R.color.colorPrimary)));
            }else {
                orderIndicator.setImageTintList(ColorStateList.valueOf(itemView.getContext().getResources().getColor(R.color.successGreen)));
            }
            deliveryStatus.setText(deliveredDate);
        }
    }
}
