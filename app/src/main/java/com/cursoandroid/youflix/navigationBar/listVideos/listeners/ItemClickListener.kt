package com.cursoandroid.youflix.navigationBar.listVideos.listeners

import com.cursoandroid.youflix.navigationBar.listVideos.models.ItemData

interface ItemClickListener {

    fun onVideoClickListener(itemData: ItemData)
    fun onVideoLongClickListener(itemData: ItemData)

}