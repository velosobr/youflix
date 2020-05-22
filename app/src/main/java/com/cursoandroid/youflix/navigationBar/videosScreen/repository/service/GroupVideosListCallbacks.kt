package com.cursoandroid.youflix.navigationBar.videosScreen.repository.service

import com.cursoandroid.youflix.navigationBar.videosScreen.models.GroupOfVideosListViewModel

interface GroupVideosListCallbacks {
    fun onSuccess(GroupVideosList: MutableList<GroupOfVideosListViewModel>)
    fun onError()
}
