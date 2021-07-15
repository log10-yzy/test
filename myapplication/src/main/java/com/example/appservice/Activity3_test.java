package com.example.appservice;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Activity3_test extends AppCompatActivity {

    public static final String K="第三个activity";
    private Button button1;
    private Button button2;
    private Button button3;
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        Log.v(K,"OnCreate"+hashCode());

        init();

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent=new Intent(Activity3_test.this, Activity1_test.class);//显式
//                Intent intent=new Intent("com.example.Activity3_test.Action_START");//隐式
//                startActivity(intent);
//                  finish();
                Intent intent=new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://www.baidu.com"));
                startActivity(intent);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(Activity3_test.this, test4.class);
                intent.putExtra("update","hello,i am Activity3");
                startActivityForResult(intent,1);//请求吗
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Activity3_test.this, Activity3_test.class);
                startActivity(intent);
            }
        });
    }

    @Override
    //请求吗  ，处理结果  ，intent数据
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case 1:
                if(requestCode==RESULT_OK){
                    String str= data.getStringExtra("return_date");
                    Log.d("返回值",str);
                    textView.setText(str);
                }
                break;
            default:
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.add:
                Toast.makeText(Activity3_test.this,"add",Toast.LENGTH_SHORT).show();
                break;
            case R.id.move:
                Toast.makeText(Activity3_test.this,"Move",Toast.LENGTH_SHORT).show();
                break;
            default:
        }
        return true;
    }
    private void init(){
        button1=findViewById(R.id.app31);
        button2=findViewById(R.id.app32);
        button3=findViewById(R.id.app33);
        textView=findViewById(R.id.Main1text);
    }

}