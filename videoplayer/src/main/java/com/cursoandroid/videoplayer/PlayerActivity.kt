package com.cursoandroid.videoplayer

import android.net.Uri
import android.os.Bundle
import android.widget.MediaController
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity

class PlayerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_player)

        val videoView: VideoView = findViewById(R.id.videoView)

        //Creating MediaController
        val mediaController = MediaController(this)
        mediaController.setAnchorView(videoView)

        //Location of Media File
        val uri = Uri.parse("android.resource://" + packageName + "/" + R.raw.introducao)

        //Starting videoView by Setting MediaController And URI
        videoView.setMediaController(mediaController)
        videoView.setVideoURI(uri)
        videoView.requestFocus()
        videoView.start()
    }
}
