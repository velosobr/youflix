package com.cursoandroid.youflix.navigationBar.videosScreen.repository.service

import android.util.Log
import android.widget.Toast
import com.cursoandroid.youflix.Data.API.RetrofitConfig
import com.cursoandroid.youflix.Data.API.VideosListAccess
import com.cursoandroid.youflix.navigationBar.videosScreen.helper.YoutubeConfig
import com.cursoandroid.youflix.navigationBar.videosScreen.models.GroupOfVideosListViewModel
import com.cursoandroid.youflix.navigationBar.videosScreen.models.Resultado
import com.cursoandroid.youflix.navigationBar.videosScreen.repository.LocalData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.lang.ref.WeakReference

class GroupVideosListServiceImpl : GroupVideosListService {
    override fun returnGroupVideosListService(
        groupVideosListServiceCallback: GroupVideosListCallbacks,
        channelPosition: Int
    ) {
        var result: Resultado
        val groupVideosList = mutableListOf<GroupOfVideosListViewModel>()

        val groupOfVideosListServiceAccess =
            RetrofitConfig().returnRetrofit().create(VideosListAccess::class.java)

        GlobalScope.launch(Dispatchers.IO) {
            val response = groupOfVideosListServiceAccess.restoreVideosList(
                "snippet",
                "date",
                "5",
                LocalData.YOUTUBE_API_KEY,
                YoutubeConfig.channelList[channelPosition]
            )
            println("########################### response :$response")
            groupVideosList.add(
                GroupOfVideosListViewModel(
                    response.body()!!.items[0].snippet.channelId,
                    response.body()!!.items[0].snippet.channelTitle,
                    response.body()!!.items
                )
            )
            groupVideosListServiceCallback.onSuccess(groupVideosList)
        }

    }

}
