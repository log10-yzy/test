package com.example.lifecycle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity implements View.OnClickListener{

    private Button button;
    private Button button2;

    private Button button_f1;
    private Button button_f2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        button=findViewById(R.id.app31);
        button2=findViewById(R.id.app32);

        button_f1=findViewById(R.id.blue);
        button_f2=findViewById(R.id.red);
        button_f1.setOnClickListener(this);
        button_f2.setOnClickListener(this);

        Log.v("MainActivity3","OnCreate");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity3.this,MainActivity.class);
                startActivity(intent);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity3.this,MainActivity2.class);
                startActivity(intent);
            }
        });
    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.v("MainActivity3_test","OnStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.v("MainActivity3_test","OnRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.v("MainActivity3_test","OnResume");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.v("MainActivity3_test","OnStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.v("MainActivity3_test","OnDestroy");
    }

    @Override
    public void onClick(View v) {
        FragmentManager manager=getSupportFragmentManager();//创建一个fragment管理器
        FragmentTransaction transaction= manager.beginTransaction();//
        switch (v.getId()){
            case R.id.blue:
                BlankFragment blankFragment=new BlankFragment();
                Bundle bundle=new Bundle();
                bundle.putString("message","这是BlankFragment的信息");
                blankFragment.setArguments(bundle);
                    transaction.replace(R.id.framelayout,blankFragment);//替换页面
                    transaction.addToBackStack(null);//保存空栈
                    break;
            case R.id.red:
                //要想添加没有 UI 的片段，请使用 add(Fragment, String) 从 Activity 添加片段（为片段提供一个唯一的字符串“标记”，而不是视图 ID）

                BlankFragment2 blankFragment2=new BlankFragment2();
                blankFragment2.setiFragmentCallBack(new IFragmentCallBack() {
                    @Override
                    public void sentMsgToActivity(String msg) {
                        Toast.makeText(MainActivity3.this,msg,Toast.LENGTH_SHORT).show();
                    }
                    @Override
                    public String getMsgFromActivity(String msg) {
                        return "hello ,i'am come from activity!";
                    }
                });
                transaction.replace(R.id.framelayout,blankFragment2);
                transaction.addToBackStack(null);
                break;
        }
        transaction.commit();
        Toast.makeText(MainActivity3.this,"页面已经替换",Toast.LENGTH_SHORT).show();
    }
}