package com.example.thread;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button start;
    private Button stop;
    private Button bind;
    private Button unbind;
    private View view;


    private static final String TAG="MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG,"OnCreate"+hashCode());

        start=findViewById(R.id.Server_start);
        start.setOnClickListener(this);
        stop=findViewById(R.id.Server_stop);
        stop.setOnClickListener(this);
        bind=findViewById(R.id.bind);
        bind.setOnClickListener(this);
        unbind=findViewById(R.id.unbind);
        unbind.setOnClickListener(this);
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.v(TAG,"OnStart"+hashCode());
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.v(TAG,"OnRestart"+hashCode());
    }


    @Override
    protected void onResume() {
        super.onResume();
        Log.v(TAG,"OnResume"+hashCode());
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.v(TAG,"OnPause"+hashCode());
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.v(TAG,"OnStop"+hashCode());
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.v(TAG,"OnDestroy"+hashCode());
        unbindService(connection);
    }

    @Override
    public void onClick(View v) {
        Service(v.getId());
    }
    private  void Service(int id){
        switch (id){
            case 0:
            case R.id.Server_start:
                startService(new Intent(this,myService.class));
                break;
            case 1:
            case R.id.Server_stop:
                stopService(new Intent(this,myService.class));
                break;
            case 2:
            case R.id.bind:
                bindService(new Intent(this,myService.class),connection, Context.BIND_AUTO_CREATE);
                break;
            case 3:
            case R.id.unbind:
                unbindService(connection);//解绑桥梁
                break;
        }
    }

    private ServiceConnection connection=new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {

        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };
}