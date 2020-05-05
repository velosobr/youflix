package com.cursoandroid.youflix.navigationBar.listVideos.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.cursoandroid.youflix.R
import com.cursoandroid.youflix.navigationBar.listVideos.models.BaseItem
import com.cursoandroid.youflix.navigationBar.listVideos.models.Item
import com.squareup.picasso.Picasso

class VideoAdapter(
    private val listVideos: List<BaseItem>,
    private val context: Context
) : Adapter<VideoAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var title: TextView = itemView.findViewById(R.id.textTitle)
        var cover: ImageView = itemView.findViewById(R.id.imageCover)
    }

    override fun getItemViewType(position: Int): Int {

        return listVideos[position].type

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.adapter_video, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listVideos.size
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val video = listVideos.get(position) as Item
        holder.title.text = video.snippet.title

        val url = video.snippet.thumbnails.high.url

        Picasso.get().load(url).into(holder.cover)
    }


}
