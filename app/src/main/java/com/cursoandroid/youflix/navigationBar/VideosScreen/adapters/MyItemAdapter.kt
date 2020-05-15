package com.cursoandroid.youflix.navigationBar.VideosScreen.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.cursoandroid.youflix.R
import com.cursoandroid.youflix.navigationBar.VideosScreen.listeners.ItemClickListener
import com.cursoandroid.youflix.navigationBar.VideosScreen.models.ItemData
import com.squareup.picasso.Picasso

class MyItemAdapter(
    private val itemDataList: List<ItemData>,
    private var itemClickListener: ItemClickListener

//TODO: se eu deixar o item click listener no construtor, como faço para enviar um lá no groups,
// na hora que tiver que passar por paramtro?
) : Adapter<MyItemAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.layout_item, parent, false)
        return MyViewHolder(view, itemClickListener)
    }

    override fun getItemCount(): Int {
        return itemDataList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.config(
            itemDataList[position]
        )

    }

    class MyViewHolder(
        itemView: View,
        private var itemClickListener: ItemClickListener
    ) : RecyclerView.ViewHolder(itemView), View.OnClickListener, View.OnLongClickListener {
        var txt_item_title: TextView = itemView.findViewById(R.id.tvTitle_layoutItem)
        var cover: ImageView = itemView.findViewById(R.id.itemImageCover_layoutItem)
        private lateinit var itemData: ItemData

        fun config(itemFromAdapter: ItemData) {
            itemData = itemFromAdapter
            txt_item_title.text = itemData.snippet.title


            val urlMedium: String? = itemData.snippet.thumbnails.medium.url

            if (urlMedium != null) {
                Picasso.get().load(urlMedium).into(cover)
            }


            itemView.setOnClickListener(this)
            itemView.setOnLongClickListener(this)
        }

        override fun onClick(view: View?) {
            itemClickListener.onVideoClickListener(itemData)
        }

        override fun onLongClick(v: View?): Boolean {
            itemClickListener.onVideoLongClickListener(itemData)
            return true
        }
    }

}
