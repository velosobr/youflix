package com.cursoandroid.youflix.navigationBar.listVideos.activity

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import com.cursoandroid.youflix.R
import com.cursoandroid.youflix.navigationBar.listVideos.data.LocalData.Companion.YOUTUBE_API_KEY
import com.cursoandroid.youflix.navigationBar.listVideos.listeners.MyPlaybackEventListener
import com.cursoandroid.youflix.navigationBar.listVideos.listeners.MyPlayerStateChangeListener
import com.google.android.youtube.player.YouTubeBaseActivity
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import com.google.android.youtube.player.YouTubePlayerView
import java.lang.ref.WeakReference

class PlayerActivity : YouTubeBaseActivity(), YouTubePlayer.OnInitializedListener {

    private lateinit var youFlixPlayerView: YouTubePlayerView
    private lateinit var idVideo: String
    private lateinit var playerStateChangeListener: MyPlayerStateChangeListener
    private lateinit var playbackEventListener: MyPlaybackEventListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_player)
        youFlixPlayerView = findViewById(R.id.viewYoutubePlayer)
        val description: TextView = findViewById(R.id.textDescriptPlayer)
        val title: TextView = findViewById(R.id.textTitlePlayer)


        val bundle = intent.extras

        if (bundle != null) {
            idVideo = bundle.getString("idVideo").toString()
            description.text = bundle.getString("description")
            title.text = bundle.getString("title")

        }
        youFlixPlayerView.initialize(YOUTUBE_API_KEY, this)
        playerStateChangeListener = MyPlayerStateChangeListener()
        playbackEventListener = MyPlaybackEventListener(WeakReference<Activity>(this))
    }

    override fun onInitializationSuccess(
        provider: YouTubePlayer.Provider?,
        youTubePlayer: YouTubePlayer?,
        wasRestored: Boolean
    ) {
        youTubePlayer?.setPlayerStateChangeListener(playerStateChangeListener)
        youTubePlayer?.setPlaybackEventListener(playbackEventListener)

        Toast.makeText(
            this,
            "Player iniciado com sucesso!!!",
            Toast.LENGTH_SHORT
        ).show()

        Log.i("state_player", "state: $wasRestored")
        if (!wasRestored) {
            youTubePlayer?.cueVideo(idVideo)


        }
    }

    override fun onInitializationFailure(
        provider: YouTubePlayer.Provider?,
        youTubeInitializationResult: YouTubeInitializationResult?
    ) {
        Toast.makeText(
            this,
            "Erro ao iniciar o player ${youTubeInitializationResult.toString()}",
            Toast.LENGTH_SHORT
        ).show()
    }
}
