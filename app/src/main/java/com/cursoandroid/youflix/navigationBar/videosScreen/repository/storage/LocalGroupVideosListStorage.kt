package com.cursoandroid.youflix.navigationBar.videosScreen.repository.storage

import com.cursoandroid.youflix.navigationBar.videosScreen.models.GroupOfVideosListViewModel

interface LocalGroupVideosListStorage {
    fun saveGroupOfVideosList(groupOfVideosList: MutableList<GroupOfVideosListViewModel>)
    fun returnGroupOfVideosList(): MutableList<GroupOfVideosListViewModel>
    fun getGroupOfVideosListById(groupOfVideosListId: String): GroupOfVideosListViewModel
}