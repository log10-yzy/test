package com.example.myapplication
import android.content.Intent
import android.icu.util.Output
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import java.io.OutputStream

class SearchActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search2)

//        var button1: Button = findViewById(R.id.search)
//        var editText: EditText = findViewById(R.id.keyword)
//        var str:String=editText.text.toString().trim();
//            button1.setOnClickListener(){
//            startSearchActivity(str)
//        }
    }
    private fun startSearchActivity(keywords:String){
        if(TextUtils.isEmpty(keywords)){
            Toast.makeText(this,"keyword不能为空",Toast.LENGTH_SHORT).show()
            return
        }
        val uri= Uri.parse("https://www.baidu.com/s?wd=$keywords")
        var intent= Intent()
        intent.action=Intent.ACTION_VIEW
        intent.data = uri
        startActivity(intent)
    }
    private fun isNullEmpty(str:String?):Boolean{
        if(str!=null&& str.isNotEmpty())
            return true
        return false
    }
/*    private fun imageviewView():View{

        return u.png
    }*/

    override fun onRestart() {
        super.onRestart()
    }
}