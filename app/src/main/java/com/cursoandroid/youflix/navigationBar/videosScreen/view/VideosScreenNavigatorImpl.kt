package com.cursoandroid.youflix.navigationBar.videosScreen.view

import android.content.Context
import android.content.Intent
import com.cursoandroid.youflix.navigationBar.videosScreen.activity.PlayerActivity
import com.cursoandroid.youflix.navigationBar.videosScreen.models.VideosListViewModel

class VideosScreenNavigatorImpl(private var fragmentContext: Context) :
    VideosScreenNavigator {
    override fun goToPlayer(videosListViewModel: VideosListViewModel) {
        val playerIntent = Intent(fragmentContext, PlayerActivity::class.java)
        playerIntent.putExtra("idVideo", videosListViewModel.id.videoId)
        playerIntent.putExtra("description", videosListViewModel.snippet.description)
        playerIntent.putExtra("title", videosListViewModel.snippet.title)
        playerIntent.putExtra("publishedAt", videosListViewModel.snippet.publishedAt)

        fragmentContext.startActivity(playerIntent)
    }
}