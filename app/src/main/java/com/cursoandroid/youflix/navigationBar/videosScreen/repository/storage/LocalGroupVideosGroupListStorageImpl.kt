package com.cursoandroid.youflix.navigationBar.videosScreen.repository.storage

import com.cursoandroid.youflix.navigationBar.videosScreen.models.GroupOfVideosListViewModel

object LocalGroupVideosGroupListStorageImpl : LocalGroupVideosListStorage {

    var groupOfVideosList: MutableList<GroupOfVideosListViewModel> = mutableListOf()

    override fun saveGroupOfVideosList(groupOfVideosListViewModel: MutableList<GroupOfVideosListViewModel>) {
        this.groupOfVideosList = groupOfVideosListViewModel
    }

    override fun returnGroupOfVideosList(): MutableList<GroupOfVideosListViewModel> {
        return groupOfVideosList
    }

    override fun getGroupOfVideosListById(groupOfVideosListId: String): GroupOfVideosListViewModel {
        return groupOfVideosList.find { it.groupOfVideosListId == groupOfVideosListId }!!
    }
}