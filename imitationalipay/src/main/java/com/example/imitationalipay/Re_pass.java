package com.example.imitationalipay;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import bean.Myslq;
import bean.User;
import bean.UtilToast;

public class Re_pass extends AppCompatActivity {
    private EditText input;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_re_pass);
        init();
    }

    private void init() {
        input=findViewById(R.id.re_email);
        textView=findViewById(R.id.re_name);
    }

    public void RePass(View view) {
        String str=input.getText().toString().trim();
        Myslq myslq=new Myslq(this);
        User user=myslq.ReQuery(str);
        if(str==null){
            UtilToast.Util(Re_pass.this, "输入的邮箱不能为空");
        }else {
            if(user.getEmail().equals(str)){
                textView.setText(user.getUser()+"  "+user.getPass());
            }
            else{
                UtilToast.Util(Re_pass.this,"输入的账户不存在");
            }
        }
    }
}