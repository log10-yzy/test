package com.example.myapplication

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        lateinit var intentFilter:IntentFilter
        intentFilter.addAction("yzy_test")
        registerReceiver(TextBroadCoastRec(),intentFilter)

    }

    private  class TextBroadCoastRec: BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            TODO("Not yet implemented")
            Log.d("MainActivity","上课了")
        }

    }
    override fun onStop(){
        super.onStop()
    }
}