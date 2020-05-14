package com.cursoandroid.youflix.navigationBar.VideosScreen.listeners

import com.cursoandroid.youflix.navigationBar.VideosScreen.models.ItemData

interface ItemClickListener {

    fun onVideoClickListener(itemData: ItemData)
    fun onVideoLongClickListener(itemData: ItemData)

}