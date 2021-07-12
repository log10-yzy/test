package com.example.thread;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.TextView;

public class Thread_Activity extends AppCompatActivity {

    public static final int Date=1;
    private TextView textView;
    private Button button;

    private Handler handler=new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread_);
    }
}