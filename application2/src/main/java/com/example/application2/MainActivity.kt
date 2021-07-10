package com.example.application2

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lateinit var intentFilter:IntentFilter
        intentFilter.addAction("android.test")
        registerReceiver(TestBroadcastReceiver(),intentFilter)
    }

    override fun onDestroy() {
        super.onDestroy()
        if(TestBroadcastReceiver()!=null){
            unregisterReceiver(TestBroadcastReceiver())
        }
    }


    private class TestBroadcastReceiver:BroadcastReceiver(){
        override fun onReceive(context: Context?, intent: Intent?) {
            TODO("Not yet implemented")
            intent!!.action?.let { Log.d("test", it) }
        }

    }


}