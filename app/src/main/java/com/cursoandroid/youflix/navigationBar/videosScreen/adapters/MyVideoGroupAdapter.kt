package com.cursoandroid.youflix.navigationBar.listVideos.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cursoandroid.youflix.R
import com.cursoandroid.youflix.navigationBar.videosScreen.adapters.MyItemAdapter
import com.cursoandroid.youflix.navigationBar.videosScreen.listeners.ItemClickListener
import com.cursoandroid.youflix.navigationBar.videosScreen.models.GroupOfVideosListViewModel
import com.cursoandroid.youflix.navigationBar.videosScreen.models.VideosListViewModel

class MyVideoGroupAdapter(
    private val context: Context,
    private var itemClickListener: ItemClickListener

) : RecyclerView.Adapter<MyVideoGroupAdapter.MyViewHolder>() {
    private var dataList = mutableListOf<GroupOfVideosListViewModel>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder {
        val itemView: View =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.layout_group, parent, false)

        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(
        holder: MyViewHolder,
        position: Int
    ) {
        val groupOfVideosList = dataList[position]
        holder.itemGroupTitle.text = groupOfVideosList.headerTitle

        val itemData: List<VideosListViewModel> = dataList[position].listItem

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

    fun updateGroupVideosList(groupOfVideosList: List<GroupOfVideosListViewModel>) {
        dataList.addAll(groupOfVideosList)
    }
}