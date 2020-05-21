package com.cursoandroid.youflix.navigationBar.videosScreen.view

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.cursoandroid.youflix.R
import com.cursoandroid.youflix.navigationBar.listVideos.adapters.MyVideoGroupAdapter
import com.cursoandroid.youflix.navigationBar.videosScreen.controller.GroupVideosListController
import com.cursoandroid.youflix.navigationBar.videosScreen.listeners.ItemClickListener
import com.cursoandroid.youflix.navigationBar.videosScreen.models.VideosListViewModel
import com.cursoandroid.youflix.navigationBar.videosScreen.models.GroupOfVideosListViewModel
import com.cursoandroid.youflix.navigationBar.videosScreen.models.Resultado
import com.cursoandroid.youflix.navigationBar.videosScreen.repository.GroupVideosListRepositoryImpl
import com.cursoandroid.youflix.navigationBar.videosScreen.repository.service.GroupVideosListServiceImpl
import com.cursoandroid.youflix.navigationBar.videosScreen.repository.storage.LocalGroupVideosGroupListStorageImpl
import com.miguelcatalan.materialsearchview.MaterialSearchView
import kotlinx.android.synthetic.main.fragment_layout_group.view.*
import retrofit2.Retrofit

class VideosScreenFragment : Fragment(), GroupVideosListView {

    private lateinit var fragmentContext: Context
    private lateinit var controller: GroupVideosListController
    private lateinit var presenter: GroupVideosListPresenterImpl

    private lateinit var searchView: MaterialSearchView
    private lateinit var retrofit: Retrofit
    private lateinit var myRecyclerViewVideos: RecyclerView
    private lateinit var result: Resultado

    override fun onAttach(context: Context) {
        fragmentContext = context
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_videos_screen, container, false)

        val localGroupVideosGroupList = LocalGroupVideosGroupListStorageImpl
        val groupVideosListService = GroupVideosListServiceImpl()
        val groupVideosListRepository =
            GroupVideosListRepositoryImpl(localGroupVideosGroupList, groupVideosListService)

        presenter = GroupVideosListPresenterImpl()

        controller = GroupVideosListController(groupVideosListRepository, presenter, this)

        myRecyclerViewVideos = view.findViewById(R.id.my_recycler_view_main)

        val layoutManager = LinearLayoutManager(activity)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        view.videoGroupListRecyclerView.layoutManager = layoutManager


        val rvAdapter = MyVideoGroupAdapter(fragmentContext, object : ItemClickListener {
            override fun onVideoClickListener(videosListViewModel: VideosListViewModel) {
                controller.onSelectVideo(fragmentContext, videosListViewModel)
            }

            override fun onVideoLongClickListener(videosListViewModel: VideosListViewModel) {
                TODO("Not yet implemented")
            }

        })
        return view
    }


    override fun setViewModel(viewModels: List<GroupOfVideosListViewModel>) {
        TODO("Not yet implemented")
    }


}
