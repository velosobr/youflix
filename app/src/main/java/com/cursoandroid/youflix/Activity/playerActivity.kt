package com.cursoandroid.youflix.Activity

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import com.cursoandroid.youflix.Data.LocalData.Companion.YOUTUBE_API_KEY
import com.cursoandroid.youflix.Listeners.MyPlaybackEventListener
import com.cursoandroid.youflix.Listeners.MyPlayerStateChangeListener
import com.cursoandroid.youflix.R
import com.google.android.youtube.player.YouTubeBaseActivity
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import com.google.android.youtube.player.YouTubePlayerView
import java.lang.ref.WeakReference

class playerActivity : YouTubeBaseActivity(), YouTubePlayer.OnInitializedListener {

    private lateinit var youflixPlayerView: YouTubePlayerView

    private lateinit var playerStateChangeListener: MyPlayerStateChangeListener
    private lateinit var playbackEventListener: MyPlaybackEventListener
    private lateinit var toolbar: Toolbar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_player)


        youflixPlayerView = findViewById(R.id.viewYoutubePlayer)
        youflixPlayerView.initialize(YOUTUBE_API_KEY, this)

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
        if (!wasRestored)
//            youTubePlayer.cueVideo("_TgrWBZ40cs")
            youTubePlayer?.cuePlaylist("PLWz5rJ2EKKc_T0fSZc9obnmnWcjvmJdw_")
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

