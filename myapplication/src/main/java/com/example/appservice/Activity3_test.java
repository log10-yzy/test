package com.example.appservice;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class Activity3_test extends AppCompatActivity {

    public static final String K="第三个activity";
    private EditText editText;
    TextView textView;
    private Button button1;
    private Button button2;
    private Button button3;
    private ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        ControllerActivity.addActivity(this);
        Log.v(K,"OnCreate"+hashCode());

        getSupportActionBar().hide();
        init();
////////////-------------------------//////////////////
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str=editText.getText().toString();
                if(str.equals("0")){
                    Intent intent=new Intent(Activity3_test.this, Activity1_test.class);//显式
//                    Intent intent=new Intent("com.example.Activity3_test.Action_START");//隐式
                    startActivity(intent);
                    finish();
                }
                if(str.equals("1")){
                    Intent intent=new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("http://www.baidu.com"));
                    startActivity(intent);
                }
                if(str.equals("2")){
                    if(progressBar.getVisibility()==View.VISIBLE){
                        progressBar.setVisibility(View.GONE);
                    }
                    else{
                        progressBar.setVisibility(View.VISIBLE);
                        progressBar.setProgress(progressBar.getProgress()+10);
                    }
                }
                if(str.equals("3")){
                    ProgressDialog progressDialog=new ProgressDialog(Activity3_test.this);
                    progressDialog.setTitle("this is Pro_Dialog");
                    progressDialog.setMessage("Loading......");
                    progressDialog.setCancelable(true);
                    progressDialog.show();
                }
            }
        });
///---------------------------------------------------------------//
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(Activity3_test.this, test4.class);
                intent.putExtra("update","hello,i am Activity3");
                startActivityForResult(intent,1);//请求ma
            }
        });
//---------------------------------------------------------------------//
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                test4.StartAction(Activity3_test.this,"date1","date2");
                AlertDialog.Builder alert=new AlertDialog.Builder(Activity3_test.this);
                alert.setTitle("这是一个Dialog");
                alert.setMessage("are you true do this?");
                alert.setCancelable(false);
                alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                alert.show();
            }
        });
    }
/////////////////////////////////////////////////
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
//菜单布局//////////////////////////////////////////////////////////
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
        progressBar=findViewById(R.id.img);
        textView=findViewById(R.id.Main1text);
        editText=findViewById(R.id.input_text);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ControllerActivity.removeActivity(this);
    }
}