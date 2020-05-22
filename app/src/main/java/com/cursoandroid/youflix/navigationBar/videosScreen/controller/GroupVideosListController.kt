package com.cursoandroid.youflix.navigationBar.videosScreen.controller

import android.content.Context
import android.content.Intent
import androidx.core.content.ContextCompat.startActivity
import com.cursoandroid.youflix.navigationBar.videosScreen.activity.PlayerActivity
import com.cursoandroid.youflix.navigationBar.videosScreen.models.VideosListViewModel
import com.cursoandroid.youflix.navigationBar.videosScreen.repository.GroupVideosListRepository
import com.cursoandroid.youflix.navigationBar.videosScreen.view.GroupVideosListPresenter
import com.cursoandroid.youflix.navigationBar.videosScreen.view.GroupVideosListView

class GroupVideosListController(
    private val groupVideosListRepository: GroupVideosListRepository,
    private val presenter: GroupVideosListPresenter,
    private val view: GroupVideosListView
) {
    fun onSelectVideo(
        fragmentContext: Context,
        videosListViewModel: VideosListViewModel
    ) {
        val intent = Intent(fragmentContext, PlayerActivity::class.java)
        intent.putExtra("idVideo", videosListViewModel.id.videoId)
        intent.putExtra("description", videosListViewModel.snippet.description)
        intent.putExtra("title", videosListViewModel.snippet.title)
        intent.putExtra("publishedAt", videosListViewModel.snippet.publishedAt)

//        TODO: startActivity()
    }

    fun onViewCreated() {
        TODO("Not yet implemented")
    }
}
