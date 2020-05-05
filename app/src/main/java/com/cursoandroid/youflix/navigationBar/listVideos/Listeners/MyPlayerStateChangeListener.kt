package com.cursoandroid.youflix.navigationBar.listVideos.Listeners

import android.util.Log
import com.google.android.youtube.player.YouTubePlayer

open class MyPlayerStateChangeListener : YouTubePlayer.PlayerStateChangeListener {

    fun showMessage(message: String) {
        Log.i("tagMessage", message)
    }

    override fun onAdStarted() {
        showMessage("onAdStarted")
    }

    override fun onLoading() {
        showMessage("onLoading")
    }

    override fun onVideoStarted() {
        showMessage("onVideoStarted")
    }

    override fun onLoaded(p0: String?) {
        showMessage("onLoaded $p0")
    }

    override fun onVideoEnded() {
        showMessage("onVideoEnded")
    }

    override fun onError(p0: YouTubePlayer.ErrorReason?) {
        showMessage("onError $p0")
    }
}