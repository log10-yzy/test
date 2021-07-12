package com.example.contentprovider;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.function.IntToDoubleFunction;


public class MainActivity extends AppCompatActivity {

    private Button call_button;
    private Button get_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        get_button=findViewById(R.id.get_content);
        get_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,MainActivity2.class);
                startActivity(intent);
            }
        });


        call_button=findViewById(R.id.call);
        call_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                if(ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED){
//                    ActivityCompat.requestPermissions(MainActivity.this, new String[]{(Manifest.permission.CALL_PHONE)},1);
//                }
//                else {
//                    call();
//                }
                Intent intent=new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:10000"));
                startActivity(intent);
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch(requestCode){
            case 1:
            if(grantResults.length>0&&grantResults[0]==PackageManager.PERMISSION_GRANTED){
                call();
            }
            else{
                Toast.makeText(this,"you denied the permission",Toast.LENGTH_SHORT).show();
            }
            break;
        }
    }

    private void call() {
        try{
            Intent intent=new Intent(Intent.ACTION_CALL);
            intent.setData(Uri.parse("tel:10000"));
            startActivity(intent);
        }
        catch (SecurityException exception){
            exception.printStackTrace();
        }

    }
}