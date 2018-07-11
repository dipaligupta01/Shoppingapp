package com.example.user.project_test2;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class AdapterCart extends RecyclerView.Adapter<AdapterCart.ViewHolder> {
    Context context;
    ArrayList<Product> list;

    public AdapterCart(Context context, ArrayList<Product> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(context).inflate(R.layout.row_cart_adapter, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Product product = list.get(i);
        // viewHolder.imageView.setImageResource(Cart.getpImage());
        viewHolder.textViewmodel.setText(product.getpModel());
        viewHolder.textViewprice.setText(product.getpPrice());

        Picasso.with(context).load(Config.IMG_URL+product.getpImage()).into(viewHolder.imageView);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setData(ArrayList<Product> mlist) {
        list = mlist;
        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView imageView;
        TextView textViewprice, textViewmodel;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image_view);
            textViewmodel = itemView.findViewById(R.id.text_view_model);
            textViewprice = itemView.findViewById(R.id.text_view_price);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Toast.makeText(context, "CLicked", Toast.LENGTH_SHORT).show();

            context.startActivity(new Intent(context, PaymentActivity.class));
        }
    }

}



