package com.cursoandroid.youflix.navigationBar.videosScreen.repository

import com.cursoandroid.youflix.navigationBar.videosScreen.repository.service.GroupVideosListCalbacks

interface GroupVideosListRepository {
    fun returnGroupMovieListRepository(groupVideosListCalbacks: GroupVideosListCalbacks)
}
