package com.cursoandroid.youflix.helper

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitConfig {
    lateinit var retrofit: Retrofit
    val okHttp = OkHttpClient.Builder()
    fun returnRetrofit(): Retrofit {
        retrofit = Retrofit.Builder()
            .baseUrl(YoutubeConfig.URL_BASE)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttp.build())
            .build()

        return retrofit
    }
}