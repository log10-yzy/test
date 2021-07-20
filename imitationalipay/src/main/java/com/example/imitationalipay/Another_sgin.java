package com.example.imitationalipay;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Field;
import java.util.Timer;
import java.util.TimerTask;

public class Another_sgin extends AppCompatActivity implements View.OnClickListener {
    TextView phoneNumberStr;
    TextView codeCountDown;
    TextView reGetCode;
    EditText input,phone;
    private int recLen = 60;

    Timer timer = new Timer();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_another_sgin);
        init();//初始化组件

    }

    TimerTask task = new TimerTask() {
        @Override
        public void run() {

            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    codeCountDown.setVisibility(View.VISIBLE);
                    recLen--;
                    codeCountDown.setText(recLen+"秒后重新获取验证码");//动态调整秒数下降
                    if(recLen <= 0){
                        timer.cancel();
                        codeCountDown.setVisibility(View.GONE);
                        reGetCode.setText("重新获得验证码");//倒计时结束，修改为重新获得验证码

                        reGetCode.setVisibility(View.VISIBLE);//修改控件的可见性
                        reGetCode.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                reGetCode.setVisibility(View.GONE);
                                recLen = 60;
                                codeCountDown.setVisibility(View.VISIBLE);
                                codeCountDown.setText(recLen+"秒后重新获取验证码");
                                timer = new Timer();
                                //task一般情况下使用过一次后无法再使用，但可以借助反射使得task重新工作，修改state属性即可，state为1时表示已经使用过无法再次使用，为0表示可以使用
                                Field field;
                                try {
                                    field = TimerTask.class.getDeclaredField("state");
                                    field.setAccessible(true);
                                    field.set(task, 0);
                                } catch (NoSuchFieldException e) {
                                    e.printStackTrace();
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                timer.schedule(task, 1000, 1000);
                            }
                        });
                    }
                }
            });
        }
    };


    private void init() {

        phoneNumberStr = findViewById(R.id.phone_number_str);
        codeCountDown = findViewById(R.id.re_get_code);
        reGetCode = findViewById(R.id.re_get_code);
        reGetCode.setOnClickListener(this);
        reGetCode.setVisibility(View.GONE);
        input=findViewById(R.id.input_phone);
        phone=findViewById(R.id.phone_code);
    }

    @Override
    public void onClick(View v) {
        Intent intent;//设置单击事件使得倒计时可以继续
        switch (v.getId()){
            case R.id.get_code:
                reGetCode.setVisibility(View.GONE);
                timer.schedule(task, 1000, 1000);       // timeTask
                break;
        }
    }

    public void DengLu(View view) {
        if(isEmpty(input)||isEmpty(phone)){
            Toast.makeText(this,"手机号不能为空",Toast.LENGTH_SHORT).show();
            return;
        }
        Intent intent=new Intent(this, MainActivity2.class);
        intent.putExtra("user",input.getText().toString());
        startActivity(intent);
    }

    public void Get_code(View view) {
        phoneNumberStr.setText("验证码已发送至你的手机");
        timer.schedule(task, 1000, 1000);       // 启动一个1000毫秒（1秒）的定时任务
    }
    public Boolean isEmpty(EditText editText){
        String str= editText.getText().toString();
        return TextUtils.isEmpty(str);
    }
}