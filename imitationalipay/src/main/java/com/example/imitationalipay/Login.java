package com.example.imitationalipay;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
public class Login extends AppCompatActivity {

    private Button button;
    private EditText UserEditText;
    private EditText PassEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button_instantiation();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isEmpty(UserEditText)||isEmpty(PassEditText)){
                    Toast.makeText(Login.this,"用户名和密码不能为空",Toast.LENGTH_SHORT).show();
                    return;
                }
                Intent intent=new Intent(Login.this, MainActivity2.class);
                intent.putExtra("user",UserEditText.getText().toString());
                startActivity(intent);
            }
        });
        
    }

    private void Button_instantiation(){
        UserEditText=findViewById(R.id.user);
        PassEditText=findViewById(R.id.password);
        button=findViewById(R.id.login);
    }


    public Boolean isEmpty(EditText editText){
        String str= editText.getText().toString();
        return TextUtils.isEmpty(str);
    }
}