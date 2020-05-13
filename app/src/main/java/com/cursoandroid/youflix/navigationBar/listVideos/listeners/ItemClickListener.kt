package com.cursoandroid.youflix.navigationBar.listVideos.listeners

import com.cursoandroid.youflix.navigationBar.listVideos.models.VideoViewModel

interface ItemClickListener {

    fun onVideoClickListener(itemData: VideoViewModel)
    fun onVideoLongClickListener(itemData: VideoViewModel)

}