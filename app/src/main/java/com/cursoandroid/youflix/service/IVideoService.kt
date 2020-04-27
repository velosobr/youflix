package com.cursoandroid.youflix.service

interface IVideoService {
    fun returnVideoList(videoServiceCallback: IVideoCallbacks)
}