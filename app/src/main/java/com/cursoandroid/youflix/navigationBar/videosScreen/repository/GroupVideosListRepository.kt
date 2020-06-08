package com.cursoandroid.youflix.navigationBar.videosScreen.repository

import com.cursoandroid.youflix.navigationBar.videosScreen.repository.service.GroupVideosListCallbacks

interface GroupVideosListRepository {
    fun returnGroupMovieListRepository(groupVideosListCallbacks: GroupVideosListCallbacks)
}
