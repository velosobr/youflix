package com.cursoandroid.youflix.navigationBar.listVideos.models

class Item(
    type: Int,
    var id: ItemId,
    var snippet: Snippet
) : BaseItem(type)
