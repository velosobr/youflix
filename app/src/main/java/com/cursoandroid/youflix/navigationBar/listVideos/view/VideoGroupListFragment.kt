package com.cursoandroid.youflix.navigationBar.listVideos.view

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.cursoandroid.youflix.R
import com.cursoandroid.youflix.navigationBar.favoriteVideos.repository.VideoDao
import com.cursoandroid.youflix.navigationBar.favoriteVideos.repository.VideoRoomDatabase
import com.cursoandroid.youflix.navigationBar.listVideos.activity.PlayerActivity
import com.cursoandroid.youflix.navigationBar.listVideos.adapters.MyVideoGroupAdapter
import com.cursoandroid.youflix.navigationBar.listVideos.controller.VideoGroupListController
import com.cursoandroid.youflix.navigationBar.listVideos.listeners.ItemClickListener
import com.cursoandroid.youflix.navigationBar.listVideos.models.VideoViewModel
import kotlinx.android.synthetic.main.fragment_layout_group.view.*

class VideoGroupListFragment : Fragment(), VideoGroupListView, VideoViewModelClickListener {

    private lateinit var fragmentContext: Context
    private lateinit var controller: VideoGroupListController
    private lateinit var presenter: VideoPresenterImpl
    private lateinit var videoDao: VideoDao


    override fun onAttach(context: Context) {
        fragmentContext = context
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_layout_group, container, false)

        videoDao = VideoRoomDatabase.getInstance().videoDao()

        presenter = VideoPresenterImpl()

        controller = VideoGroupListController(
            presenter, this
        )

        val layoutManager = LinearLayoutManager(activity)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        view.videoGroupListRecyclerView.layoutManager = layoutManager

        val myVideoGroupAdapter = MyVideoGroupAdapter(fragmentContext, object : ItemClickListener {
            override fun onVideoClickListener(itemData: VideoViewModel) {
                onVideoClick(itemData)
            }

            override fun onVideoLongClickListener(itemData: VideoViewModel) {
                Log.i("Longclick", "long click teste")
            }

        })

        view.videoGroupListRecyclerView.adapter = myVideoGroupAdapter

        controller.onViewCreated()
        return view
    }


    override fun setViewModel(viewModels: List<com.cursoandroid.youflix.navigationBar.listVideos.view.VideoViewModel>) {
        TODO("Not yet implemented")
    }


    override fun showMovieList() {
        TODO("Not yet implemented")
    }

    override fun hideMovieList() {
        TODO("Not yet implemented")
    }

    override fun onVideoClick(video: VideoViewModel) {
        val intent = Intent(fragmentContext, PlayerActivity::class.java)
        intent.putExtra("idVideo", video.id.videoId)
        intent.putExtra("description", video.snippet.description)
        intent.putExtra("title", video.snippet.title)
        intent.putExtra("publishedAt", video.snippet.publishedAt)

        startActivity(intent)


    }

}
