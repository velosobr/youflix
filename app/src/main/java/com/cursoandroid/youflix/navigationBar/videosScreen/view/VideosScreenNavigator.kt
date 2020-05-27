package com.cursoandroid.youflix.navigationBar.videosScreen.view

import com.cursoandroid.youflix.navigationBar.videosScreen.models.VideosListViewModel

interface VideosScreenNavigator {
    fun goToPlayer(videosListViewModel: VideosListViewModel)
}
