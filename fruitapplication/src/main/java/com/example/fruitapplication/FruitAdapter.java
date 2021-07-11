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
    private Context context;
    private List<Fruit> fruits;

    public FruitAdapter(@NonNull Context context, int resource, @NonNull List<Fruit> objects) {
        super(context, resource, objects);
        this.context=context;
        this.fruits=objects;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView==null){
            convertView=LayoutInflater.from(context).inflate(R.layout.fruit_item2, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.textView=convertView.findViewById(R.id.tv_name);
            viewHolder.imageView=convertView.findViewById(R.id.tv_pic);
            convertView.setTag(viewHolder);
        }else {
            viewHolder=(ViewHolder)convertView.getTag();
        }

        viewHolder.textView.setText(fruits.get(position).getName());
        viewHolder.imageView.setImageResource(fruits.get(position).getRes());
        return convertView;
    }
    class ViewHolder{
        private TextView textView;
        private ImageView imageView;
    }
}
