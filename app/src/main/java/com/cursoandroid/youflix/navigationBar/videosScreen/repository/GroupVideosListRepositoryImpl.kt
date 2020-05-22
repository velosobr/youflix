package com.cursoandroid.youflix.navigationBar.videosScreen.repository

import com.cursoandroid.youflix.navigationBar.videosScreen.models.GroupOfVideosListViewModel
import com.cursoandroid.youflix.navigationBar.videosScreen.repository.service.GroupVideosListCallbacks
import com.cursoandroid.youflix.navigationBar.videosScreen.repository.service.GroupVideosListServiceImpl
import com.cursoandroid.youflix.navigationBar.videosScreen.repository.storage.LocalGroupVideosGroupListStorageImpl

class GroupVideosListRepositoryImpl(
    private val localGroupVideosGroupList: LocalGroupVideosGroupListStorageImpl,
    private val groupVideosListService: GroupVideosListServiceImpl
) : GroupVideosListRepository {
    override fun returnGroupMovieListRepository(groupVideosListCallbacks: GroupVideosListCallbacks) {


        groupVideosListService.returnGroupVideosListService(object : GroupVideosListCallbacks {

            override fun onSuccess(GroupVideosList: MutableList<GroupOfVideosListViewModel>) {
                localGroupVideosGroupList.saveGroupOfVideosList(GroupVideosList)
                groupVideosListCallbacks.onSuccess(GroupVideosList)
            }

            override fun onError() {
                groupVideosListCallbacks.onError()

            }

        })
    }

}
