package com.cursoandroid.youflix.navigationBar.videosScreen.view

import com.cursoandroid.youflix.navigationBar.videosScreen.models.GroupOfVideosListViewModel

interface GroupVideosListView {
    fun setViewModel(viewModels: MutableList<GroupOfVideosListViewModel>)
    fun showGroupVideosList()
    fun hideGroupVideosList()

}
