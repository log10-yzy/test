package com.example.appservice

import android.app.Activity
import android.net.Uri
import android.widget.VideoView
import android.widget.EditText
import android.os.Bundle
import android.os.Environment
import android.widget.Button
import android.widget.RadioButton

class VideoViewDemo : Activity() {
    /** Called when the activity is first created.  */
    var playButton: Button? = null
    var videoView: VideoView? = null
    var rtspUrl: EditText? = null
    var radioStream: RadioButton? = null
    var radioFile: RadioButton? = null
    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    //play rtsp stream
    private fun PlayRtspStream(rtspUrl: String) {
        videoView!!.setVideoURI(Uri.parse(rtspUrl))
        videoView!!.requestFocus()
        videoView!!.start()
    }

    //play rtsp stream
    private fun PlayLocalFile(filePath: String) {
        videoView!!.setVideoPath(Environment.getExternalStorageDirectory().toString() + "/" + filePath)
        videoView!!.requestFocus()
        videoView!!.start()
    }
}