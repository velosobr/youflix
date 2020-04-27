package com.cursoandroid.youflix.service

import com.cursoandroid.youflix.models.Resultado
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface IVideoServiceAccess {

    /**
     * https://www.googleapis.com/youtube/v3/
    search
    ?part=snippet
    &order=date
    &maxResults=20
    &key=AIzaSyAHMsmSqDQRZcaXzdYI11sJx_jRpb2JmZQ
    &channelId=UCVHFbqXqoYvEWM1Ddxl0QDg

    https://www.googleapis.com/youtube/v3/search?part=snippet&order=date&maxResults=20&key=AIzaSyAHMsmSqDQRZcaXzdYI11sJx_jRpb2JmZQ&channelId=UCVHFbqXqoYvEWM1Ddxl0QDg
     */
    @GET("search")
    fun restoreVideoList(
        @Query("part") part: String,
        @Query("order") order: String,
        @Query("maxResults") maxResults: String,
        @Query("key") key: String,
        @Query("channelId") channelId: String
    ): Call<Resultado>
}