package com.cursoandroid.youflix.navigationBar.videosScreen.view

import com.cursoandroid.youflix.navigationBar.videosScreen.models.GroupOfVideosListViewModel

interface GroupVideosListPresenter {

    fun convertModel(videos: GroupOfVideosListViewModel)
}
