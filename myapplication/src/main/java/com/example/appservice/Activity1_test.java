package com.example.appservice;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Activity1_test extends AppCompatActivity {

//    private static final String K="第一个activity";
//    private Button button1;
//    private Button button2;
//    private Button button3;
    private ExecutorService executorService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        executorService= Executors.newFixedThreadPool(1);
        doAsyncCode();
//        Log.v(K,"OnCreate"+hashCode());
//
//        button1=findViewById(R.id.app1);
//        button1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent=new Intent(Activity1_test.this, Activity1_test.class);
//                startActivity(intent);
//            }
//        });
//        button2=findViewById(R.id.app2);
//        button2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent=new Intent(Activity1_test.this, Activity2_test.class);
//                startActivity(intent);
//            }
//        });
//        button3=findViewById(R.id.app3);
//        button3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent=new Intent(Activity1_test.this, Activity3_test.class);
//                startActivity(intent);
//            }
//        });
    }
    private void doAsyncCode() {
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                // 执行你的耗时操作代码

                doOnUiCode();
            }
        });
    }

    private void doOnUiCode() {
        Handler uiThread = new Handler(Looper.getMainLooper());
        uiThread.post(new Runnable() {
            @Override
            public void run() {
                // 更新你的UI
            }
        });
    }
    @Override
    protected void onStop() {
        super.onStop();

        if (!executorService.isShutdown()) {
            executorService.shutdownNow();
        }
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