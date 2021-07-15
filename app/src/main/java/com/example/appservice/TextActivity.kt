package com.example.appservice
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.text.TextUtils
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class TextActivity : AppCompatActivity() {
    var videoView:VideoView?=null



    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.text_activity)
        var intent=intent

        var buttonPlay:Button=findViewById(R.id.play)

        var editTextUrl:EditText=findViewById(R.id.url)
        var radioStream:RadioButton=findViewById(R.id.Stream)
        var radioFile:RadioButton=findViewById(R.id.local_file)

        var text1:TextView = findViewById(R.id.show)
        text1.append(intent.getStringExtra("user"))

        var button1: Button = findViewById(R.id.search)
        var editText: EditText = findViewById(R.id.keyword)

        buttonPlay.setOnClickListener(){
            if(radioStream.isChecked){
                playStreamActivity(editTextUrl.text.toString().trim())
            }
            else if(radioFile.isChecked){
                playFileActivity(editTextUrl.text.toString().trim())
            }
        }
        videoView=findViewById(R.id.startPlay)


        button1.setOnClickListener(){
            startSearchActivity( editText.text.toString().trim())
        }
    }

    private fun startSearchActivity(keywords:String){
        if(TextUtils.isEmpty(keywords)){
            Toast.makeText(this,"keyword不能为空", Toast.LENGTH_SHORT).show()
            return
        }
        val uri= Uri.parse("https://www.baidu.com/s?wd=$keywords")
        var intent= Intent()
        intent.action= Intent.ACTION_VIEW
        intent.data = uri
        startActivity(intent)
    }


    private fun playStreamActivity(stream:String){
        videoView?.setVideoURI(Uri.parse(stream))
        videoView!!.requestFocus()
        videoView!!.start()

    }
    private fun playFileActivity(file:String){
        videoView!!.setVideoPath(Environment.getExternalStorageState()+file)
        videoView!!.requestFocus()
        videoView!!.start()

    }













}



//        var any=intent?.extras?.getString("name","can'nt find the key name")
//        setSupportActionBar(findViewById(R.id.toolbar))
//        button1=findViewById(R.id.second)
////singleTop  在顶层了就不在创建
//        //singleTask  杀死他顶层的
