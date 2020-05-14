package com.cursoandroid.youflix.navigationBar.listVideos.view

import com.cursoandroid.youflix.navigationBar.listVideos.models.VideoViewModel

interface VideoViewModelClickListener {
    fun onVideoClick(video: VideoViewModel)
}
