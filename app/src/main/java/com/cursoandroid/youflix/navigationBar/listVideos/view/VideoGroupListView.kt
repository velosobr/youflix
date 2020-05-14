package com.cursoandroid.youflix.navigationBar.listVideos.view

interface VideoGroupListView {
    fun setViewModel(viewModels: List<VideoViewModel>)
    fun showMovieList()
    fun hideMovieList()
}
