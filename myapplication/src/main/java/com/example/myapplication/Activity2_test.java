package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class Activity2_test extends AppCompatActivity {
    public static final String K="第二个activity";
    private Button button1;
    private Button button2;
    private Button button3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Log.v(K,"OnCreate"+hashCode());

        button1=findViewById(R.id.app21);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Activity2_test.this, Activity1_test.class);
                startActivity(intent);
            }
        });
        button2=findViewById(R.id.app22);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Activity2_test.this, Activity2_test.class);
                startActivity(intent);
            }
        });
        button3=findViewById(R.id.app23);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Activity2_test.this, Activity3_test.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.v(K,"OnStart"+hashCode()+"taskID"+getTaskId());
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.v(K,"OnRestart"+hashCode()+"taskID"+getTaskId());
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.v(K,"OnResume"+hashCode()+"taskID"+getTaskId());
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.v(K,"OnPause"+hashCode());
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.v(K,"OnStop"+hashCode()+"taskID"+getTaskId());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.v(K,"OnDestroy"+hashCode()+"taskID"+getTaskId());
    }
}