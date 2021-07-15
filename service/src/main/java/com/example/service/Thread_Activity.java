package com.example.service;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.thread.R;

public class Thread_Activity extends AppCompatActivity {

    public static final int Date=1;
    private TextView textView;
    private Button button;


    private Handler handler=new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(@NonNull Message msg) {
            switch (msg.what) {
                case Date:
                    textView.setText("Yes,i am fine");
                    return true;
                default:
                    return false;
            }
        }
    });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread_);
        button=findViewById(R.id.change);
        textView=findViewById(R.id.text1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               new Thread(new Runnable() {
                   @Override
                   public void run() {
                       Message message=new Message();
                       message.what=Date;
                       handler.sendMessage(message);
                   }
               }).start();
            }
        });

    }


}