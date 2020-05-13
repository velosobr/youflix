package com.cursoandroid.youflix.navigationBar.listVideos.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.cursoandroid.youflix.R
import com.cursoandroid.youflix.navigationBar.listVideos.listeners.ItemClickListener
import com.cursoandroid.youflix.navigationBar.listVideos.models.ItemGroup
import com.cursoandroid.youflix.navigationBar.listVideos.models.VideoViewModel

class MyVideoGroupAdapter(
    private val context: Context,
    var itemClickListener: ItemClickListener


) : Adapter<MyVideoGroupAdapter.MyViewHolder>() {
    private var itemGroups = mutableListOf<ItemGroup>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView: View =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.fragment_layout_group, parent, false)

        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return itemGroups.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = itemGroups[position]
        holder.itemGroupTitle.text = item.headerTitle

        val itemData: List<VideoViewModel> = itemGroups[position].listItem

        val itemListAdapter = MyItemAdapter(itemData, itemClickListener)

        holder.recyclerViewItemList.setHasFixedSize(true)

        holder.recyclerViewItemList.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

        holder.recyclerViewItemList.adapter = itemListAdapter

        holder.recyclerViewItemList.isNestedScrollingEnabled = false


    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var itemGroupTitle: TextView = itemView.findViewById(R.id.textItemGroupTitle)
        var recyclerViewItemList: RecyclerView =
            itemView.findViewById(R.id.videoGroupListRecyclerView)

    }
}
