package com.example.viewpager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
//泛型
public class ViewPager2Adapter extends RecyclerView.Adapter<ViewPager2Adapter.ViewpagerViewHolder> {
    List<String> text=new ArrayList<>();
    List<Integer> color=new ArrayList<>();

    ViewPager2Adapter(){
        text.add("终");
        text.add("于");
        text.add("成");
        text.add("功");
        text.add("了");

        color.add(R.color.white);
        color.add(R.color.purple_200);
        color.add(R.color.teal_200);
        color.add(R.color.red);
        color.add(R.color.orange);
    }

    @NonNull
    @Override
    public ViewpagerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
         //new一个ViewpagerViewHolder对象 通过LayoutInflater数据的页面绑定
        return new ViewpagerViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.base_pager,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewpagerViewHolder holder, int position) {//数据的绑定

        holder.textView.setText(text.get(position));//
        holder.relativeLayout.setBackgroundResource(color.get(position));//背景色的绑定
    }

    @Override
    public int getItemCount() {//滑动页面数量
        return 5;
    }

      //对RecyclerView.ViewHolder的封装
    class ViewpagerViewHolder extends RecyclerView.ViewHolder{

        RelativeLayout relativeLayout;
        TextView textView;
        public ViewpagerViewHolder(@NonNull View itemView) {
            super(itemView);
            relativeLayout=itemView.findViewById(R.id.container);
            textView=itemView.findViewById(R.id.text);
        }
    }
}
