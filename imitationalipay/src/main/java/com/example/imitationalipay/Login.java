package com.example.imitationalipay;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import bean.Myslq;
import bean.User;
import bean.UtilToast;

public class Login extends AppCompatActivity {
    private Button button;
    private EditText UserEditText;
    private EditText PassEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button_instantiation();
        getSupportActionBar().hide();
    }

//按钮初始化
    private void Button_instantiation(){
        UserEditText=findViewById(R.id.user);
        PassEditText=findViewById(R.id.password);
        button=findViewById(R.id.login);
    }


    public Boolean isEmpty(EditText editText){
        String str= editText.getText().toString();
        return TextUtils.isEmpty(str);
    }
    //登录处理
    public void Login_(View view) {
        if(isEmpty(UserEditText)||isEmpty(PassEditText)){
            Toast.makeText(this,"用户名和密码不能为空",Toast.LENGTH_SHORT).show();
            return;
        }
        String str_name=UserEditText.getText().toString().trim();
        String str_pass=PassEditText.getText().toString().trim();
        Myslq myslq=new Myslq(this);
        User user=myslq.Query(str_name);
        if(str_name==null){
            UtilToast.Util(Login.this,
                    "用户名不能为空");
        }else {
            if(user.getPass().equals(str_pass)){
                Intent intent=new Intent(Login.this, MainActivity2.class);
                intent.putExtra("user",UserEditText.getText().toString());
                startActivity(intent);
            }
            else {
                UtilToast.Util(Login.this,"密码不正确");
            }
        }

    }
//忘记密码处理
    public void Sign(View view) {
        AlertDialog.Builder alert=new AlertDialog.Builder(this);
        alert.setTitle("这是一个有风险操作");
        alert.setMessage("确定通过邮箱找回账户密码？");
        alert.setCancelable(false);
        alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent=new Intent(Login.this,Re_pass.class);
                startActivity(intent);
            }
        });
        alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        alert.show();
    }
//账户注册
    public void Count_Sign(View view) {
        Intent intent=new Intent(Login.this,Sign.class);
        startActivity(intent);
    }
//遇到问题百度
    public void Help(View view) {
        Intent intent=new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("http://www.baidu.com"));
        startActivity(intent);
    }
//其他登录方式
    public void Another_sign(View view) {

        Intent intent=new Intent(this,Another_sgin.class);
        startActivity(intent);
    }
}