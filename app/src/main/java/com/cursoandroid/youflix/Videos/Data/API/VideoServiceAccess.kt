package com.cursoandroid.youflix.Data.API

import com.cursoandroid.youflix.Videos.models.Resultado
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface VideoServiceAccess {

    /**
     * https://www.googleapis.com/youtube/v3/
    search
    ?part=snippet
    &order=date
    &maxResults=20
    &key=AIzaSyAHMsmSqDQRZcaXzdYI11sJx_jRpb2JmZQ
    &channelId=UCVHFbqXqoYvEWM1Ddxl0QDg
    &q=desenvolvimento+android

    https://www.googleapis.com/youtube/v3/search?part=snippet&order=date&maxResults=20&key=AIzaSyAHMsmSqDQRZcaXzdYI11sJx_jRpb2JmZQ&channelId=UCVHFbqXqoYvEWM1Ddxl0QDg
     */
    @GET("search")
    fun restoreVideoList(
        @Query("part") part: String,
        @Query("order") order: String,
        @Query("maxResults") maxResults: String,
        @Query("key") key: String,
        @Query("channelId") channelId: String,
        @Query("q") q: String
    ): Call<Resultado>
}