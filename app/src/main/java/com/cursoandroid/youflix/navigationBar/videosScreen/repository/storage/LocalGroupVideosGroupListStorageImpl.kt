package com.cursoandroid.youflix.navigationBar.videosScreen.repository.storage

import com.cursoandroid.youflix.navigationBar.videosScreen.models.GroupOfVideosListViewModel

object GroupVideosListMemoryRepository : LocalGroupVideosListStorage {

    var groupOfVideosList: MutableList<GroupOfVideosListViewModel> = mutableListOf()

    override fun saveGroupOfVideosList(groupOfVideosListViewModel: MutableList<GroupOfVideosListViewModel>) {
        if (groupOfVideosList.isNotEmpty()) {
//            println("saveGroupOfVideosList, groupOfVideosList.isNotEmpty: " + groupOfVideosList[0].headerTitle)
            showGroupOfVideosList()
        }
        this.groupOfVideosList.addAll(groupOfVideosListViewModel)
    }

    override fun returnGroupOfVideosList(): MutableList<GroupOfVideosListViewModel> {
        return groupOfVideosList
    }

    override fun getGroupOfVideosListById(groupOfVideosListId: String): GroupOfVideosListViewModel {
        return groupOfVideosList.find { it.groupOfVideosListId == groupOfVideosListId }!!
    }

    private fun showGroupOfVideosList() {
        for (channel in groupOfVideosList) {
            println("Testando a inclusão dos canais ${channel.headerTitle}")
        }
    }
}