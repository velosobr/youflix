package com.cursoandroid.youflix.navigationBar.videosScreen.listeners

import android.app.Activity
import android.util.Log
import android.widget.Toast
import com.google.android.youtube.player.YouTubePlayer
import java.lang.ref.WeakReference

open class MyPlaybackEventListener(val weakReference: WeakReference<Activity>) :
    YouTubePlayer.PlaybackEventListener {
    //    2 TODO: Exemplo de weakReference

    fun showMessage(message: String) {
        Toast.makeText(weakReference.get(), message, Toast.LENGTH_SHORT).show()

        Log.i("tag Message", message)
    }

    override fun onSeekTo(p0: Int) {
        showMessage("onSeekTo $p0")
    }

    override fun onBuffering(p0: Boolean) {
        showMessage("onBuffering $p0")
    }

    override fun onPlaying() {
        showMessage("Playing")
    }

    override fun onStopped() {
        showMessage("Stopped")
    }

    override fun onPaused() {
        showMessage("Paused")
    }
}