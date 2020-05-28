package com.cursoandroid.youflix.navigationBar.videosScreen.controller

import com.cursoandroid.youflix.navigationBar.videosScreen.models.GroupOfVideosListViewModel
import com.cursoandroid.youflix.navigationBar.videosScreen.models.VideosListViewModel
import com.cursoandroid.youflix.navigationBar.videosScreen.repository.GroupVideosListRepository
import com.cursoandroid.youflix.navigationBar.videosScreen.repository.service.GroupVideosListCallbacks
import com.cursoandroid.youflix.navigationBar.videosScreen.repository.storage.LocalGroupVideosListStorage
import com.cursoandroid.youflix.navigationBar.videosScreen.view.GroupVideosListView
import com.cursoandroid.youflix.navigationBar.videosScreen.view.VideosScreenNavigator

class GroupVideosListController(
    private val groupVideosListRepository: GroupVideosListRepository,
    private val navigator: VideosScreenNavigator,
    private val localGroupVideosListStorage: LocalGroupVideosListStorage,

//    private val presenter: GroupVideosListPresenter,
    private val view: GroupVideosListView

) {
    fun onVideoClick(videosListViewModel: VideosListViewModel) {
        navigator.goToPlayer(videosListViewModel)
    }
    fun onViewCreated() {
        var groupOfVideosList = localGroupVideosListStorage.returnGroupOfVideosList()
        if (groupOfVideosList.isEmpty()) {
            println("Sim, o groupOfVideosList  está vazio")
            groupVideosListRepository.returnGroupMovieListRepository(object :
                GroupVideosListCallbacks {
                override fun onSuccess(GroupVideosList: MutableList<GroupOfVideosListViewModel>) {
                    setViewModel(GroupVideosList)
                }
                override fun onError() {
                    TODO("Not yet implemented")
                }
            })
        } else {
            println("Nao, o groupOfVideosList  não está vazio")
            println("Aqui está um exemplo de item do groupOfVideosList: " + groupOfVideosList[0].headerTitle + " " + groupOfVideosList[0].listItem[0].snippet.title)

            setViewModel(groupOfVideosList)
        }
    }
    private fun setViewModel(groupVideosLists: MutableList<GroupOfVideosListViewModel>) {
        view.setViewModel(groupVideosLists)
    }
}
