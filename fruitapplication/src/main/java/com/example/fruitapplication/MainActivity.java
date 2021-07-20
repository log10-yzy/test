package com.example.fruitapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private String data[]={ "Apple","Banana","Orange","watermelon",
            "Pear", "Grape","Pineapple", "Strawberry","cherry" ,"Mango",
            "Apple","Banana","Orange","watermelon","Pear", "Grape","Pineapple", "Strawberry" , "Cherry","Mango"};

    private ListView listView;
    private FruitAdapter fruitAdapter;
    private List<Fruit> fruits;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1,data);
        init();
        listView.setAdapter(adapter);
//        initData();

    }

    private void initData(){
        for(int i=0;i<3;i++){
            fruits.add(new Fruit("草莓",R.mipmap.cao_mei));
            fruits.add(new Fruit("橘子",R.mipmap.ju_zi));
            fruits.add(new Fruit("芒果",R.mipmap.mang_guo));
            fruits.add(new Fruit("猕猴桃",R.mipmap.mi_hou_tao));
            fruits.add(new Fruit("葡萄",R.mipmap.pu_tao));
            fruits.add(new Fruit("石榴",R.mipmap.shi_liu));
            fruits.add(new Fruit("西瓜",R.mipmap.xi_gua));
            fruits.add(new Fruit("杨梅",R.mipmap.yang_mei));
            fruits.add(new Fruit("樱桃",R.mipmap.ying_tao));

        }
    }

    protected void init(){
        listView=findViewById(R.id.listView);
    }
}
