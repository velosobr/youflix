package com.cursoandroid.youflix.navigationBar.videosScreen.repository

import com.cursoandroid.youflix.navigationBar.videosScreen.models.GroupOfVideosListViewModel
import com.cursoandroid.youflix.navigationBar.videosScreen.repository.service.GroupVideosListCallbacks
import com.cursoandroid.youflix.navigationBar.videosScreen.repository.service.GroupVideosListServiceImpl
import com.cursoandroid.youflix.navigationBar.videosScreen.repository.service.YoutubeConfig
import com.cursoandroid.youflix.navigationBar.videosScreen.repository.storage.LocalGroupVideosListStorage

class GroupVideosListRepositoryImpl(
    private val localGroupVideosGroupList: LocalGroupVideosListStorage,
    private val groupVideosListService: GroupVideosListServiceImpl
) : GroupVideosListRepository {

    override fun returnGroupMovieListRepository(groupVideosListCallbacks: GroupVideosListCallbacks) {

        for (channel in YoutubeConfig.channelList.withIndex()) {

            groupVideosListService.returnGroupVideosListService(object : GroupVideosListCallbacks {

                override fun onSuccess(GroupVideosList: MutableList<GroupOfVideosListViewModel>) {
                    localGroupVideosGroupList.saveGroupOfVideosList(GroupVideosList)
                    groupVideosListCallbacks.onSuccess(GroupVideosList)
                }

                override fun onError() {
                    groupVideosListCallbacks.onError()
                }
            }, channel.index)
        }
    }

}
