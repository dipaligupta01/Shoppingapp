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

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class AdapterProduct extends RecyclerView.Adapter<AdapterProduct.ViewHolder> {

    Context context;
    ArrayList<Product> list;

    public AdapterProduct(Context context, ArrayList<Product> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_product_adapter, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Product product = list.get(i);
        //viewHolder.imageView.setImageResource(product.getpImage());
        viewHolder.textPModel.setText(product.getpModel());

        viewHolder.textPPrice.setText(product.getpPrice());

        Picasso.with(context).load(Config.IMG_URL+product.getpImage()).into(viewHolder.imageView);



    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setData(ArrayList<Product> filterList) {
        list = filterList;
        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView imageView;
        TextView textPModel, textPProcessor, textPRam, textPOs,textPCamera,textPDisplay,textPPrice;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image_view);
            textPModel = itemView.findViewById(R.id.text_pModel);

            textPPrice = itemView.findViewById(R.id.text_pPrice);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Product product = list.get(getAdapterPosition());
            Intent intent = new Intent(context, EnlargedProduct.class);
            intent.putExtra("PRODUCT", product);
            context.startActivity(intent);
        }
    }
}


