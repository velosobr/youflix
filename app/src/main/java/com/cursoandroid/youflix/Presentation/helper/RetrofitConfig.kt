package com.cursoandroid.youflix.Presentation.helper

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitConfig {
    fun init() {
        Retrofit.Builder()
            .baseUrl(YoutubeConfig().URL_BASE)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}