package com.cursoandroid.youflix.navigationBar.videosScreen.repository.service

interface GroupVideosListService {
    fun returnGroupVideosListService(
        groupVideosListServiceCallback: GroupVideosListCallbacks,
        channelPosition: Int
    )
}
