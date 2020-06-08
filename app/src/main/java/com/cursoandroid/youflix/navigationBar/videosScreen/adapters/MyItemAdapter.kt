package com.cursoandroid.youflix.navigationBar.videosScreen.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.cursoandroid.youflix.R
import com.cursoandroid.youflix.navigationBar.videosScreen.listeners.ItemClickListener
import com.cursoandroid.youflix.navigationBar.videosScreen.models.VideosListViewModel
import com.squareup.picasso.Picasso

class MyItemAdapter(
    private val videosListViewModelList: List<VideosListViewModel>,
    private var itemClickListener: ItemClickListener
) : Adapter<MyItemAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.layout_item, parent, false)
        return MyViewHolder(view, itemClickListener)
    }

    override fun getItemCount(): Int {
        return videosListViewModelList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.config(
            videosListViewModelList[position]
        )

    }

    class MyViewHolder(
        itemView: View,
        private var itemClickListener: ItemClickListener
    ) : RecyclerView.ViewHolder(itemView), View.OnClickListener, View.OnLongClickListener {
        private var txtItemTitle: TextView = itemView.findViewById(R.id.tvTitle_layoutItem)
        private var cover: ImageView = itemView.findViewById(R.id.itemImageCover_layoutItem)
        private lateinit var videosListViewModel: VideosListViewModel

        fun config(itemFromAdapter: VideosListViewModel) {
            videosListViewModel = itemFromAdapter
            txtItemTitle.text = videosListViewModel.snippet.title


            val urlMedium: String? = videosListViewModel.snippet.thumbnails.medium.url

            if (urlMedium != null) {
                Picasso.get().load(urlMedium).into(cover)
            }
            itemView.setOnClickListener(this)
            itemView.setOnLongClickListener(this)
        }

        override fun onClick(view: View?) {
            itemClickListener.onVideoClickListener(videosListViewModel)
        }

        override fun onLongClick(v: View?): Boolean {
            itemClickListener.onVideoLongClickListener(videosListViewModel)
            return true
        }
    }

}
