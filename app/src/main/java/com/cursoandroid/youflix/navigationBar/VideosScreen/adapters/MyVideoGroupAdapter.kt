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
import com.cursoandroid.youflix.navigationBar.VideosScreen.adapters.MyItemAdapter
import com.cursoandroid.youflix.navigationBar.VideosScreen.listeners.ItemClickListener
import com.cursoandroid.youflix.navigationBar.VideosScreen.models.ItemData
import com.cursoandroid.youflix.navigationBar.VideosScreen.models.ItemGroup

class MyVideoGroupAdapter(
    private val context: Context,
    private val dataList: List<ItemGroup>,
    var itemClickListener: ItemClickListener


) : Adapter<MyVideoGroupAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView: View =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.fragment_layout_group, parent, false)

        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = dataList[position]
        holder.itemGroupTitle.text = item.headerTitle

        val itemData: List<ItemData> = dataList[position].listItem

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
