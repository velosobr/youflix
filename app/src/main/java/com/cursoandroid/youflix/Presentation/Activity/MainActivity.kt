package com.cursoandroid.youflix.Presentation.Activity

import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cursoandroid.youflix.Presentation.Model.Video
import com.cursoandroid.youflix.Presentation.adapters.VideoAdapter
import com.cursoandroid.youflix.R
import com.miguelcatalan.materialsearchview.MaterialSearchView
import com.miguelcatalan.materialsearchview.MaterialSearchView.OnQueryTextListener
import com.miguelcatalan.materialsearchview.MaterialSearchView.SearchViewListener

class MainActivity : AppCompatActivity() {

    //widgets
    private lateinit var recyclerVideos: RecyclerView
    private lateinit var searchView: MaterialSearchView


    private var videos = arrayListOf<Video>()
    private lateinit var videoAdapter: VideoAdapter

    private lateinit var toolbar: Toolbar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //init components
        recyclerVideos = findViewById(R.id.recyclerVideos)
        searchView = findViewById(R.id.searchView)


//        config toolbar
        toolbar = findViewById(R.id.toolbar)
        toolbar.title = "YouFlix"
        setSupportActionBar(toolbar)

//        config RecyclerView
        restoreVideos()
        videoAdapter = VideoAdapter(videos, this)
        recyclerVideos.setHasFixedSize(true)
        recyclerVideos.setLayoutManager(LinearLayoutManager(this))
        recyclerVideos.adapter = videoAdapter

        //Configura métodos para SearchView

        searchView.setOnQueryTextListener(object : OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                println("onQueryTextSubmit")
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                println("onQueryTextChange")
                return false
            }

        })

        searchView.setOnSearchViewListener(object : SearchViewListener {
            override fun onSearchViewClosed() {
                println("onSearchViewClosed")
            }

            override fun onSearchViewShown() {
                println("onSearchViewShown")
            }

        })

    }

    private fun restoreVideos() {
        val video1 = Video()
        video1.title = "Video 1 muito interessante"
        val video2 = Video()
        video2.title = "Video 2 muito interessante"

        videos.add(video1)
        videos.add(video2)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_main, menu)

        val item = menu?.findItem(R.id.menu_search)
        searchView.setMenuItem(item)




        return true
    }
}
