package com.example.fruitapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class FruitAdapter extends ArrayAdapter<Fruit> {
    private int resourceId;
    public FruitAdapter(@NonNull Context context, int resource, @NonNull List<Fruit> objects) {
        super(context, resource, objects);
        resourceId=resource;
    }

    public View getView(int position,View contentView,ViewGroup parent){
        Fruit fruit=getItem(position);
        View view=LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
        ImageView fruitImg=view.findViewById(R.id.tv_pic);
        TextView fruitName=view.findViewById(R.id.tv_name);
        fruitImg.setImageResource(fruit.getImgId());
        fruit.setName(fruit.getName());
        return view;
    }

}
