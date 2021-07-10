package com.example.lifecycle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    private Button button;
    private Button buttonControl;
    private Button button3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        button = findViewById(R.id.app21);
        button3 = findViewById(R.id.app23);

        Log.v("MainActivity2_app","OnCreate"+hashCode()+"taskID"+getTaskId());
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity2.this,MainActivity.class);
                startActivity(intent);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity2.this,MainActivity3.class);
                startActivity(intent);
            }
        });
//        buttonControl.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                FragmentManager manager=getSupportFragmentManager();
//                Fragment fragment=manager.findFragmentById(R.id.frag2txt);
//                View view=fragment.getView();
//                TextView textView=view.findViewById(R.id.frag2txt);
//                textView.setText("动态生成的fragment");
//            }
//        });
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.v("MainActivity2_test","OnStart"+hashCode()+"taskID"+getTaskId());
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.v("MainActivity2_test","OnRestart"+hashCode()+"taskID"+getTaskId());
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.v("MainActivity2_test","OnResume"+hashCode()+"taskID"+getTaskId());
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.v("MainActivity2_test","OnStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.v("MainActivity2_test","OnDestroy"+hashCode()+"taskID"+getTaskId());
    }
}