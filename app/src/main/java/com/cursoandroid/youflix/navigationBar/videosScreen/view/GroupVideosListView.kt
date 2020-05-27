package com.cursoandroid.youflix.navigationBar.videosScreen.view

import com.cursoandroid.youflix.navigationBar.videosScreen.models.GroupOfVideosListViewModel

interface GroupVideosListView {
    fun setViewModel(viewModels: List<GroupOfVideosListViewModel>)
    fun showGroupVideosList()
    fun hideGroupVideosList()

}
