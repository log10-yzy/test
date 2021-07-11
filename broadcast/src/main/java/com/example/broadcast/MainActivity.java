package com.example.broadcast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button StaticSend;
    private Button DySend;
    private Button send;
    private MyBroadReceiver myBroadReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MainActivity content = this;
        setContentView(R.layout.activity_main);
        StaticSend=findViewById(R.id.static_bro);
        StaticSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setAction("Intent.ACTION_MEDIA_SCANNER_SCAN_FILE");
                sendBroadcast(intent);
//                LocalBroadcastManager.getInstance(content).sendBroadcast(intent);


            }
        });
/*
动态注册
                IntentFilter intentFilter=new IntentFilter();
                intentFilter.addAction("com.example.broadcast.MY_BROADCAST1");
                myBroadReceiver=new MyBroadReceiver();
                registerReceiver(myBroadReceiver,intentFilter);
                unregisterReceiver();
 */
        DySend=findViewById(R.id.dy_bro);
        IntentFilter intentFilter=new IntentFilter();
        intentFilter.addAction("com.example.broadcast.MY_BROADCAST1");
        myBroadReceiver=new MyBroadReceiver();
        registerReceiver(myBroadReceiver,intentFilter);
        DySend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             //   Toast.makeText(MainActivity.this, "DySend", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent();
                intent.setAction("sent");
                sendBroadcast(intent);

            }
        });

        send=findViewById(R.id.send);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent("com.example.broadcast.MY_BROADCAST");
                sendBroadcast(intent);
     //           sendOrderedBroadcast(intent,null);权限

            }
        });

    }

    /*
    自定义的标准广播
    1、BroadReceiver的继承
    2、Intent_filter的自定义注册
    3、Intent （自定义的注册）
    4、sendBroadcast(intent)
     */


    /*
    有序广播
    1、BroadReceiver的继承
    2、intent（）
    3、sendOrderedBroadcast(intent,null)
    4、Intent_filter的权限 priority=100
    5、abortBroadcast()广播的截断

     */

    @Override
    protected void onResume() {
//        LocalBroadcastManager.getInstance(content).registerReceiver(intent,filter);
        super.onResume();
    }

    @Override
    protected void onStop() {
//        LocalBroadcastManager.getInstance(content).unregisterReceiver(receiver);new Receiver()
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(myBroadReceiver);
    }
}