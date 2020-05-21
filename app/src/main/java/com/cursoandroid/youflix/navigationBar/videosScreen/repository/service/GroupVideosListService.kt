package com.cursoandroid.youflix.navigationBar.videosScreen.repository.service

interface GroupVideosListService {
    fun returnGroupVideosListService(
        groupVideosListServiceCallback: GroupVideosListCalbacks,
        channelPosition: Int
    )
}
