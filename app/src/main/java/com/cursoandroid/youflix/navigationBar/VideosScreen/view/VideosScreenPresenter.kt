package com.cursoandroid.youflix.navigationBar.VideosScreen.view

import com.cursoandroid.youflix.navigationBar.VideosScreen.models.ItemGroup

interface VideosScreenPresenter {

    fun convertModel(videos: ItemGroup)
}
