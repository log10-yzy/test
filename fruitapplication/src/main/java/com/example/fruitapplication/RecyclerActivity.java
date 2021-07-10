package com.example.fruitapplication;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private List<Fruit> fruits;

    @SuppressLint("WrongConstant")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle);
        recyclerView = findViewById(R.id.recycler_view);
        fruits = new ArrayList<>();
        initData();
        MyFruitAdapter myFruitAdapter = new MyFruitAdapter(fruits, RecyclerActivity.this);
        recyclerView.setAdapter(myFruitAdapter);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(RecyclerActivity.this);
        linearLayoutManager.setOrientation(OrientationHelper.HORIZONTAL);
//        GridLayoutManager gridLayoutManager=new GridLayoutManager(this,3);
//        StaggeredGridLayoutManager staggeredGridLayoutManager =new StaggeredGridLayoutManager(2, LinearLayout.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
    }

    //初始化数据
    private void initData() {
        for (int i = 0; i < 3; i++) {
            fruits.add(new Fruit("草莓", R.mipmap.cao_mei));
            fruits.add(new Fruit("橘子", R.mipmap.ju_zi));
            fruits.add(new Fruit("芒果", R.mipmap.mang_guo));
            fruits.add(new Fruit("猕猴桃", R.mipmap.mi_hou_tao));
            fruits.add(new Fruit("葡萄", R.mipmap.pu_tao));
            fruits.add(new Fruit("石榴", R.mipmap.shi_liu));
            fruits.add(new Fruit("西瓜", R.mipmap.xi_gua));
            fruits.add(new Fruit("杨梅", R.mipmap.yang_mei));
            fruits.add(new Fruit("樱桃", R.mipmap.ying_tao));
        }
    }
}