package com.cursoandroid.youflix.Presentation.Listeners

import android.util.Log
import com.google.android.youtube.player.YouTubePlayer

open class MyPlaybackEventListener : YouTubePlayer.PlaybackEventListener {
    fun showMessage(message: String) {
        Log.i("tagMessage", message)
    }

    override fun onSeekTo(p0: Int) {
        showMessage("onSeekTo $p0");
    }

    override fun onBuffering(p0: Boolean) {
        showMessage("onBuffering $p0");
    }

    override fun onPlaying() {
        showMessage("Playing");
    }

    override fun onStopped() {
        showMessage("Stopped");
    }

    override fun onPaused() {
        showMessage("Paused");
    }
}