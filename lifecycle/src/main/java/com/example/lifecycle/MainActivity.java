package com.example.lifecycle;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private Button button2;
    private Button button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=findViewById(R.id.app1);
        button2=(Button) findViewById(R.id.app2);
        button3=findViewById(R.id.app3);
        Log.v(MainActivity.class.getSimpleName(),"OnCreate"+hashCode()+"taskID"+getTaskId());//standard
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,MainActivity2.class);
                startActivity(intent);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,MainActivity3.class);
                startActivity(intent);
            }
        });

//        FragmentManager manager=getSupportFragmentManager();//获取管理器
//        FragmentTransaction transaction=manager.beginTransaction();//开启事务
//        //动态添加一个fragment对象
//        fragment_two fragmentTwo=new fragment_two();
//
//        transaction.replace(R.id.content,fragmentTwo);//id容器add
//
//        transaction.commit();//提交事务

    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.v("MainActivity_test","OnStart"+hashCode()+"taskID"+getTaskId());
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.v("MainActivity_test","OnRestart"+hashCode()+"taskID"+getTaskId());
    }


    @Override
    protected void onResume() {
        super.onResume();
        Log.v("MainActivity_test","OnResume"+hashCode()+"taskID"+getTaskId());
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.v("MainActivity_test","OnStop"+hashCode()+"taskID"+getTaskId());
        finish();
        finishAffinity();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.v("MainActivity_test","OnDestroy"+hashCode()+"taskID"+getTaskId());
    }
}