package com.example.fruitapplication;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyFruitAdapter {
    private List<Fruit> fruits;
    private Context context;

    public MyFruitAdapter(List<Fruit> fruits, Context context) {
        this.fruits = fruits;
        this.context = context;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView textView;
        private ImageView imageView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tv_name);
            imageView = itemView.findViewById(R.id.tv_pic);
        }
    }
}
