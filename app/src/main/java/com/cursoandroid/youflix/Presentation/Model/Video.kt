package com.cursoandroid.youflix.Presentation.Model

class Video {
    var title: String
    var description: String
    var date: String
    var cover: String
    var videoID: String

    constructor(
        title: String = "",
        description: String = "",
        date: String = "",
        cover: String = "",
        videoID: String = ""
    ) {
        this.title = title
        this.description = description
        this.date = date
        this.cover = cover
        this.videoID = videoID
    }
}