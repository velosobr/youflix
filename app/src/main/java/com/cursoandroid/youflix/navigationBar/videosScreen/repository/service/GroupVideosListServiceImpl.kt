package com.cursoandroid.youflix.navigationBar.videosScreen.repository.service

import android.util.Log
import com.cursoandroid.youflix.Data.API.RetrofitConfig
import com.cursoandroid.youflix.Data.API.VideosListAccess
import com.cursoandroid.youflix.navigationBar.videosScreen.helper.YoutubeConfig
import com.cursoandroid.youflix.navigationBar.videosScreen.models.GroupOfVideosListViewModel
import com.cursoandroid.youflix.navigationBar.videosScreen.models.Resultado
import com.cursoandroid.youflix.navigationBar.videosScreen.repository.LocalData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GroupVideosListServiceImpl : GroupVideosListService {
    override fun returnGroupVideosListService(
        groupVideosListServiceCallback: GroupVideosListCalbacks,
        channelPosition: Int
    ) {
        var result: Resultado
        val groupVideosList = mutableListOf<GroupOfVideosListViewModel>()

        val groupOfVideosListServiceAccess =
            RetrofitConfig().returnRetrofit().create(VideosListAccess::class.java)

        val requestCall: Call<Resultado> = groupOfVideosListServiceAccess.restoreVideosList(
            "snippet",
            "date",
            "5",
            LocalData.YOUTUBE_API_KEY,
            YoutubeConfig.channelList[channelPosition]
        )

        requestCall.enqueue(
            object : Callback<Resultado> {

                override fun onResponse(call: Call<Resultado>, response: Response<Resultado>) {
                    Log.d("resultado", "resultado: $response")
                    if (response.isSuccessful) {
                        result = response.body()!!
                        groupVideosList.add(
                            GroupOfVideosListViewModel(
                                result.items[0].snippet.channelId,
                                result.items[0].snippet.channelTitle,
                                result.items
                            )
                        )
                        groupVideosListServiceCallback.onSuccess(groupVideosList)
                        return
                    }
                }

                override fun onFailure(call: Call<Resultado>, t: Throwable) {
                    Log.e("error: ", "testando failure")
                    t.printStackTrace()
                    groupVideosListServiceCallback.onError()
                }
            })
    }

}
