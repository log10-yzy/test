package com.example.imitationalipay;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import bean.Myslq;
import bean.User;
import bean.UtilToast;

public class Sign extends AppCompatActivity {
    private EditText user,pass,email;
    private RadioButton men,women;

    private Myslq myslq;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign);
        init();
        myslq=new Myslq(this);
    }


    private void init() {
        user=findViewById(R.id.user);
        pass=findViewById(R.id.password);
        email=findViewById(R.id.email);
        men=findViewById(R.id.man);
        women=findViewById(R.id.woman);
    }

    public void Commit(View view) {
        String S_user=user.getText().toString().trim();
        String S_pass=pass.getText().toString().trim();
        String S_email=email.getText().toString().trim();
        String S_sex="";
        if(men.isChecked()){
            S_sex="男";
        }
        if(women.isChecked()){
            S_sex="女";
        }
        if(S_user.isEmpty()||S_pass.isEmpty()||S_email.isEmpty()||S_sex.isEmpty()){
            UtilToast.Util(this,"请完善必要信息");
            return;
        }
        User users=new User();
        users.setUser(S_user);
        users.setGenerate(S_sex);
        users.setEmail(S_email);
        users.setPass(S_pass);

        Long userId=myslq.InsertUser(users);
        if(userId!=-1){
            Toast.makeText(this,"注册成功",Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this,"注册失败",Toast.LENGTH_SHORT).show();
        }
        finish();
    }
}