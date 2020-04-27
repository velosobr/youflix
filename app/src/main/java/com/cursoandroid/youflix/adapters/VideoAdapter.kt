package com.cursoandroid.youflix.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.cursoandroid.youflix.Activity.MainActivity
import com.cursoandroid.youflix.R
import com.cursoandroid.youflix.models.Item

class VideoAdapter(
    listVideos: List<Item>,
    mainActivity: MainActivity
) : Adapter<VideoAdapter.ViewHolder>() {
    private var videos = listVideos
    private var context: Context = mainActivity


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var title: TextView = itemView.findViewById(R.id.textTitle)
        var cover: ImageView = itemView.findViewById(R.id.imageCover)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.adapter_video, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return videos.size
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var video = videos.get(position)
        holder.title.text = video.snippet.title
    }
}
