package com.example.viewpager2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;


import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener{
    private LinearLayout llWei,llContent,llFind,llMain;
    private ImageView ivWei,ivContent,ivFind,ivMain,ivNow;
    ViewPager2 viewPager2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        initPager();
        initView();
    }
    public void initPager(){//viewpager 控制设配适
        viewPager2=findViewById(R.id.id_viewpager);
        ArrayList<Fragment> fragments=new ArrayList<>();
        fragments.add(BlankFragment.newInstance("微信聊天"));
        fragments.add(BlankFragment.newInstance("通讯录"));
        fragments.add(BlankFragment.newInstance("发现"));
        fragments.add(BlankFragment.newInstance("我"));
        MyFragmentPagerAdapter myFragmentPagerAdapter=new MyFragmentPagerAdapter(getSupportFragmentManager(),getLifecycle(),fragments);
        viewPager2.setAdapter(myFragmentPagerAdapter);
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
            }

            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                changeTab(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                super.onPageScrollStateChanged(state);
            }
        });

    }

    private void initView(){
        llWei=findViewById(R.id.wei_chat);
        llWei.setOnClickListener(this);
        llContent=findViewById(R.id.content);
        llContent.setOnClickListener(this);
        llFind=findViewById(R.id.find);
        llFind.setOnClickListener(this);
        llMain=findViewById(R.id.main);
        llMain.setOnClickListener(this);

        ivWei=findViewById(R.id.tab_wei_chat);
        ivContent=findViewById(R.id.tab_content);
        ivFind=findViewById(R.id.tab_find);
        ivMain=findViewById(R.id.tab_main);

        ivWei.setSelected(true);
        ivNow=ivWei;
    }

    @Override
    public void onClick(View v) {
        changeTab(v.getId());
    }
    private void changeTab(int position){

        ivNow.setSelected(false);
        switch (position){
            case R.id.tab_wei_chat:
                viewPager2.setCurrentItem(0);
            case 0:
                ivWei.setSelected(true);
                ivNow=ivWei;
                break;
            case R.id.tab_content:
                viewPager2.setCurrentItem(1);
            case 1:
                ivContent.setSelected(true);
                ivNow=ivContent;
                break;
            case R.id.tab_find:
                viewPager2.setCurrentItem(2);
            case 2:
                ivFind.setSelected(true);
                ivNow=ivFind;
                break;
            case R.id.tab_main:
                viewPager2.setCurrentItem(3);
            case 3:
                ivMain.setSelected(true);
                ivNow=ivMain;
                break;
        }
    }
}