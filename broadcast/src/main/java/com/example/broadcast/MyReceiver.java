package com.example.broadcast;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {

    /*
    静态广播
    <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
    <uses-permission android:name="android.permission.RECEIVE_BOOT_COMPLETED" />
    两个权限
    <intent-filter>-->
          <action android:name="android.intent.action.BOOT_COMPLETED" />
          </intent-filter>
          一个filter注册器
     */
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context,"我是一个接收者,开机启动",Toast.LENGTH_SHORT).show();
    }
}