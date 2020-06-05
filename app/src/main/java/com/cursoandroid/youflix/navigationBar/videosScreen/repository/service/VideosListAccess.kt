package com.cursoandroid.youflix.Data.API

import com.cursoandroid.youflix.navigationBar.videosScreen.models.Resultado
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface VideosListAccess {

    /**
     * https://www.googleapis.com/youtube/v3/
    search
    ?part=snippet
    &order=date
    &maxResults=20
    &key=ccccc
    &channelId=UCVHFbqXqoYvEWM1Ddxl0QDg
    &q=desenvolvimento+android

    https://www.googleapis.com/youtube/v3/videos?id=7lCDEYXw3mM&key=YOUR_API_KEY
    &fields=items(id,snippet(channelId,title,categoryId),statistics)&part=snippet,statistics

         */
    @GET("search")
    suspend fun restoreVideosList(
        @Query("part") part: String,
        @Query("order") order: String,
        @Query("maxResults") maxResults: String,
        @Query("key") key: String,
        @Query("channelId") channelId: String
//        ,@Query("q") q: String
    ): Response<Resultado>
    // !deferred
}
