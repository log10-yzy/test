package com.example.appservice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class test4 extends AppCompatActivity {

    private TextView textView;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test4);
        ControllerActivity.addActivity(this);
        textView=findViewById(R.id.test);
        button=findViewById(R.id.back);
        Intent intent=getIntent();
        String str=intent.getStringExtra("update");
        textView.setText(str);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.putExtra("return_date","hi,i am test4");
                setResult(RESULT_OK,intent);
//                ControllerActivity.FinnishAll();
//                finish();
            }
        });



    }
    public static void  StartAction(Context context, String date1, String date2){
        Intent intent = new Intent(context,test4.class);
        intent.putExtra("param1",date1);
        intent.putExtra("param2",date2);
        context.startActivities(new Intent[]{intent});
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        ControllerActivity.removeActivity(this);
    }
}