package com.example.myapplication

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.gson.Gson

class MainActivity : AppCompatActivity() {
    lateinit var  button1: Button
    lateinit var  input:EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)//调用
        button1=findViewById(R.id.login)

        button1.setOnClickListener{
        // startMessage(number = 12345678,msg="hello")
             startSecondActivity()
            //   searchActivity()
        }
        Log.d("test","onCreate")
    }



/*    fun startMessage(number: Int,msg:String){
        val uri= Uri.parse("smsto:"+number);
        var it= Intent()
        it.action=Intent.ACTION_SENDTO
        it.putExtra("sms_body",msg);
        it.setType("vnd.android-dir/mms-sms")
        it.setData(uri)//要设置的数据

        startActivity(it)//执行跳转
    }*/
    private fun startSecondActivity(){
        val intent = Intent(this, TextActivity::class.java)
        input=findViewById(R.id.user)
        val usersName=input.text.toString().trim()
        if(TextUtils.isEmpty(usersName)){
            Toast.makeText(this,"用户名不能为空,请重新输入",Toast.LENGTH_SHORT).show()
            return
        }
        intent.putExtra("user",usersName)//数据传输
        startActivity(intent)
    }
    private fun searchActivity(){
        val intent=Intent(this,SearchActivity2::class.java)
        startActivity(intent)
    }




    override fun onStart() {
        Log.d("test","onStart")
        super.onStart()
    }

    override fun onPause() {
        super.onPause()
        Log.d("test","onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("test","onStop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("test","onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("test","onDestroy")
    }
}