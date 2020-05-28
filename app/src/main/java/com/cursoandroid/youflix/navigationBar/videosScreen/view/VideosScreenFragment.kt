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
import com.cursoandroid.youflix.navigationBar.videosScreen.models.GroupOfVideosListViewModel
import com.cursoandroid.youflix.navigationBar.videosScreen.models.VideosListViewModel
import com.cursoandroid.youflix.navigationBar.videosScreen.models.Resultado
import com.cursoandroid.youflix.navigationBar.videosScreen.repository.GroupVideosListRepositoryImpl
import com.cursoandroid.youflix.navigationBar.videosScreen.repository.service.GroupVideosListServiceImpl
import com.cursoandroid.youflix.navigationBar.videosScreen.repository.storage.GroupVideosListMemoryRepository
import com.miguelcatalan.materialsearchview.MaterialSearchView
import kotlinx.android.synthetic.main.fragment_layout_group.view.*
import kotlinx.android.synthetic.main.fragment_videos_screen.*
import kotlinx.android.synthetic.main.fragment_videos_screen.view.*
import kotlinx.android.synthetic.main.fragment_videos_screen.view.my_recycler_view_main
import retrofit2.Retrofit

class VideosScreenFragment : Fragment(), ItemClickListener, GroupVideosListView {

    private lateinit var fragmentContext: Context
    private lateinit var controller: GroupVideosListController

    /**    private lateinit var presenter: GroupVideosListPresenterImpl
    private lateinit var searchView: MaterialSearchView
    private lateinit var retrofit: Retrofit
    private lateinit var myRecyclerViewVideos: RecyclerView
    private lateinit var result: Resultado
     */

    override fun onAttach(context: Context) {
        fragmentContext = context
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_videos_screen, container, false)


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val GroupVideosListMemoryRepository = GroupVideosListMemoryRepository
        val groupVideosListService = GroupVideosListServiceImpl()

        val groupVideosListRepository =
            GroupVideosListRepositoryImpl(GroupVideosListMemoryRepository, groupVideosListService)

//        presenter = GroupVideosListPresenterImpl()
        val navigator = VideosScreenNavigatorImpl(fragmentContext)

        controller = GroupVideosListController(
            groupVideosListRepository,
            navigator,
            GroupVideosListMemoryRepository,
            this
        )

        val layoutManager = LinearLayoutManager(activity)
        view.my_recycler_view_main.layoutManager = layoutManager

        val rvAdapter = MyVideoGroupAdapter(fragmentContext, this)
        view.my_recycler_view_main.adapter = rvAdapter
        controller.onViewCreated()
    }

    override fun setViewModel(viewModels: List<GroupOfVideosListViewModel>) {
        activity?.runOnUiThread {
            var rvAdapter = my_recycler_view_main.adapter as MyVideoGroupAdapter
            rvAdapter.updateGroupVideosList(viewModels)
        }
    }

    override fun onVideoClickListener(videosList: VideosListViewModel) {
        controller.onVideoClick(videosList)
    }

    override fun onVideoLongClickListener(videosList: VideosListViewModel) {
        controller.onVideoClick(videosList)
    }

    override fun showGroupVideosList() {
        my_recycler_view_main.visibility = View.VISIBLE
    }

    override fun hideGroupVideosList() {
        TODO("Not yet implemented")
    }


}
