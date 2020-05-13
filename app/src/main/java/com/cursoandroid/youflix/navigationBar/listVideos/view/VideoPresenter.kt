package com.cursoandroid.youflix.navigationBar.listVideos.view

import com.cursoandroid.youflix.navigationBar.listVideos.models.VideoViewModel
import com.cursoandroid.youflix.navigationBar.listVideos.repository.Video

interface VideoPresenter {
    fun convertModel(video: Video): VideoViewModel

}