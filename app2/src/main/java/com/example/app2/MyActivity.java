package com.example.app2;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MyActivity extends AppCompatActivity {

    protected MyReceiver receiver;
    protected IntentFilter intentFilter;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity);

        receiver = new MyReceiver();
        intentFilter = new IntentFilter();
        intentFilter.addAction("zy_send");
        intentFilter.setPriority(200);
        registerReceiver(receiver,intentFilter);
    }
    public void send(View view){
        Intent intent = new Intent();
        //定义广播事件类型
        intent.setAction("zy_send");
        //发送广播
        sendBroadcast(intent);
    }
    protected void onDestroy(){
        super.onDestroy();
        unregisterReceiver(receiver);
    }
}