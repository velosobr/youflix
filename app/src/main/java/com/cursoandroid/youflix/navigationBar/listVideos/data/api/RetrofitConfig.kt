package com.cursoandroid.youflix.Data.API

import com.cursoandroid.youflix.navigationBar.listVideos.helper.YoutubeConfig
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitConfig {
    private lateinit var retrofit: Retrofit
    private val okHttp = OkHttpClient.Builder()

    fun returnRetrofit(): Retrofit {
        retrofit = Retrofit.Builder()
            .baseUrl(YoutubeConfig.URL_BASE)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttp.build())
            .build()

        return retrofit
    }
}