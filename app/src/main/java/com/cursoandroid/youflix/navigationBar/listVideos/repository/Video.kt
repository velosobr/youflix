package com.cursoandroid.youflix.navigationBar.listVideos.repository

data class Video(
    val title: String,
    val description: String,
    var publishedAt: String,
    val cover: String,
    val videoID: String,
    var channelTitle: String,
    val favorite: Boolean = false
)