package com.cursoandroid.youflix.navigationBar.videosScreen.listeners

import com.cursoandroid.youflix.navigationBar.videosScreen.models.VideosListViewModel

interface ItemClickListener {

    fun onVideoClickListener(videosListViewModel: VideosListViewModel)
    fun onVideoLongClickListener(videosListViewModel: VideosListViewModel)

}