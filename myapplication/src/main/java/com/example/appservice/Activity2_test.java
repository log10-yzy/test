package com.example.appservice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Activity2_test extends AppCompatActivity {
//    public static final String K="第二个activity";
    private Button button1;
//    private Button button2;
//    private Button button3;
    private TextView textView;
    private MyService myService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
//        Log.v(K,"OnCreate"+hashCode());
        textView=findViewById(R.id.Main1text);
        Intent intent=new Intent();
        intent.setAction("com.test.myservice");
        intent.setPackage("com.example.appservice");

        bindService(intent,new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                myService=MyService.Stub.asInterface(service);
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {

            }
        },BIND_AUTO_CREATE);
        button1=findViewById(R.id.app21);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Toast.makeText(Activity2_test.this,myService.getName()+myService.getId()+"num="+myService.getNumbeer(),Toast.LENGTH_SHORT).show();
                    textView.setText("书名："+myService.getName()+"\n书号:"+myService.getId()+"\n num:"+myService.getNumbeer());
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        });
//        button2=findViewById(R.id.app22);
//        button2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent=new Intent(Activity2_test.this, Activity2_test.class);
//                startActivity(intent);
//            }
//        });
//        button3=findViewById(R.id.app23);
//        button3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent=new Intent(Activity2_test.this, Activity3_test.class);
//                startActivity(intent);
//            }
//        });
    }

//    @Override
//    protected void onStart() {
//        super.onStart();
//        Log.v(K,"OnStart"+hashCode()+"taskID"+getTaskId());
//    }
//
//    @Override
//    protected void onRestart() {
//        super.onRestart();
//        Log.v(K,"OnRestart"+hashCode()+"taskID"+getTaskId());
//    }
//
//    @Override
//    protected void onResume() {
//        super.onResume();
//        Log.v(K,"OnResume"+hashCode()+"taskID"+getTaskId());
//    }
//
//    @Override
//    protected void onPause() {
//        super.onPause();
//        Log.v(K,"OnPause"+hashCode());
//    }
//
//    @Override
//    protected void onStop() {
//        super.onStop();
//        Log.v(K,"OnStop"+hashCode()+"taskID"+getTaskId());
//    }
//
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        Log.v(K,"OnDestroy"+hashCode()+"taskID"+getTaskId());
//    }
}