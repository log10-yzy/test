package com.example.viewpager2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager2 viewPager2=findViewById(R.id.viewpager);
        ViewPager2Adapter viewPager2Adapter=new ViewPager2Adapter();//创建一个设配器
        viewPager2.setAdapter(viewPager2Adapter);
    }
}