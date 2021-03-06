package com.cursoandroid.youflix.navigationBar.videosScreen.models

data class Snippet(
    var publishedAt: String,
    var channelId: String,
    var title: String,
    var description: String,
    var thumbnails: SnippetThumbnails,
    var channelTitle: String,
    var liveBroadcastContent: String
)
