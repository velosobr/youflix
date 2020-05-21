package com.cursoandroid.youflix.navigationBar.videosScreen.repository.service

import com.cursoandroid.youflix.navigationBar.videosScreen.models.GroupOfVideosListViewModel

interface GroupVideosListCalbacks {
    fun onSuccess(GroupVideosList: MutableList<GroupOfVideosListViewModel>)
    fun onError()
}
