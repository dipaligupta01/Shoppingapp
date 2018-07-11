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

import java.util.ArrayList;

public class AdapterCategory extends RecyclerView.Adapter<AdapterCategory.ViewHolder> {

    Context context;
    ArrayList<Category> list;

    public AdapterCategory(Context context, ArrayList<Category> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(context).inflate(R.layout.row_category_adapter, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Category category = list.get(i);
        viewHolder.imageView.setImageResource(category.getCatImage());
        viewHolder.textViewCategory.setText(category.getCatName());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView imageView;
        TextView textViewCategory;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image_view);
            textViewCategory = itemView.findViewById(R.id.text_view_category);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Category category= list.get(getAdapterPosition());
            Intent intent = new Intent(context, DetailActivity.class);
            intent.putExtra("CAT_ID", category.getCatId());
            intent.putExtra("CAT_NAME", category.getCatName());
            context.startActivity(intent);
        }
    }

}


