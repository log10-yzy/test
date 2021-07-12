package com.example.contentprovider;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import android.Manifest;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {

    ArrayAdapter<String> adapter;
    List<String> list=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ListView listView=findViewById(R.id.content_view);
        adapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,list);
        listView.setAdapter(adapter);

        if(ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS)!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.READ_CONTACTS},1);
        }
        else{
            readContacts();
        }
    }


    private void readContacts() {
        Cursor cursor=null;
        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

                //ContactsContract.CommonDataKinds就是uri.pause的封装
                cursor=getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,null,null,null);
            }
            if(cursor!=null){
                while(cursor.moveToNext()){
                    //获取姓名
                    String displayName=cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
                    //获取手机号
                    String number=cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                    list.add(displayName+" : "+number);
                }
                adapter.notifyDataSetChanged();
            }
        }
        catch (SecurityException e){
            e.printStackTrace();
        }
        finally {
            if(cursor!=null){
                cursor.close();
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode){
            case 1:
                if(grantResults.length>0&&grantResults[0]==PackageManager.PERMISSION_GRANTED){
                    readContacts();
                }
                else{
                    Toast.makeText(this,"you denied the permission",Toast.LENGTH_SHORT).show();
                }
        }
    }
}