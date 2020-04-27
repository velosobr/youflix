package com.cursoandroid.youflix.service

import com.cursoandroid.youflix.models.Video

interface IVideoCallbacks {
    fun onSuccess(videoList: List<Video>)
    fun onError()
}