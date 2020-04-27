package com.cursoandroid.youflix.Activity

import android.os.Bundle
import android.util.Log
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cursoandroid.youflix.Data.LocalData
import com.cursoandroid.youflix.R
import com.cursoandroid.youflix.adapters.VideoAdapter
import com.cursoandroid.youflix.helper.RetrofitConfig
import com.cursoandroid.youflix.helper.YoutubeConfig
import com.cursoandroid.youflix.models.Item
import com.cursoandroid.youflix.models.Resultado
import com.cursoandroid.youflix.service.IVideoServiceAccess
import com.miguelcatalan.materialsearchview.MaterialSearchView
import com.miguelcatalan.materialsearchview.MaterialSearchView.OnQueryTextListener
import com.miguelcatalan.materialsearchview.MaterialSearchView.SearchViewListener
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import java.util.*

class MainActivity : AppCompatActivity() {

    //widgets
    private lateinit var recyclerVideos: RecyclerView
    private lateinit var searchView: MaterialSearchView
    private lateinit var toolbar: Toolbar

    private lateinit var videoAdapter: VideoAdapter

    //Retrofit
    private lateinit var retrofit: Retrofit

    private var videos: List<Item> = ArrayList()
    private lateinit var result: Resultado

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //init components
        recyclerVideos = findViewById(R.id.recyclerVideos)
        searchView = findViewById(R.id.searchView)

        //config retrofit
        retrofit = RetrofitConfig().returnRetrofit()


        //config toolbar
        toolbar = findViewById(R.id.toolbar)
        toolbar.title = "YouFlix"
        setSupportActionBar(toolbar)

        //Recupera Videos
        restoreVideos()


//        config RecyclerView
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

    fun restoreVideos() {
        val videoServiceAccess = retrofit.create(IVideoServiceAccess::class.java)

        videoServiceAccess.restoreVideoList(
            "snippet",
            "date",
            "20",
            LocalData.YOUTUBE_API_KEY,
            YoutubeConfig.CHANNEL_ID
        ).enqueue(
            object : Callback<Resultado> {
                override fun onResponse(call: Call<Resultado>, response: Response<Resultado>) {
                    Log.d("resultado", "resultado: $response");
                    if (response.isSuccessful) {
                        println("entrou no if do is Success")
                        result = response.body()!!
                        videos = result.items
                        println("Resultado: ${result.items[0].id.videoId}")
                    }
                }

                override fun onFailure(call: Call<Resultado>, t: Throwable) {
                    println("testando failure")
                    t.printStackTrace()
                }


            })

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_main, menu)

        val item = menu?.findItem(R.id.menu_search)
        searchView.setMenuItem(item)




        return true
    }
}
