package com.example.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class MyBroadReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(MyBroadReceiver.class.getSimpleName(),"已经启动");
        Toast.makeText(context,"我是一个接收者,动态广播接收",Toast.LENGTH_SHORT).show();

        abortBroadcast();//广播的截断
    }
}