package com.cursoandroid.youflix.navigationBar.listVideos.Activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cursoandroid.youflix.Data.API.RetrofitConfig
import com.cursoandroid.youflix.Data.API.VideoServiceAccess
import com.cursoandroid.youflix.R
import com.cursoandroid.youflix.navigationBar.listVideos.Listeners.RecyclerItemClickListener
import com.cursoandroid.youflix.navigationBar.listVideos.adapters.VideoAdapter
import com.cursoandroid.youflix.navigationBar.listVideos.helper.YoutubeConfig
import com.cursoandroid.youflix.navigationBar.listVideos.models.Item
import com.cursoandroid.youflix.navigationBar.listVideos.models.Resultado
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

    //Retrofit
    private lateinit var retrofit: Retrofit

    private var videosList: List<Item> = ArrayList()
    private lateinit var result: Resultado
    private lateinit var videoAdapter: VideoAdapter

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

        //Configura métodos para SearchView

        searchView.setOnQueryTextListener(object : OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {

                restoreVideos(query)
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                println("onQueryTextChange")
                return false
            }

        })

        searchView.setOnSearchViewListener(object : SearchViewListener {
            override fun onSearchViewClosed() {
                restoreVideos("")
            }

            override fun onSearchViewShown() {
                println("onSearchViewShown")
            }

        })

    }

    fun restoreVideos(search: String = "") {

        val videoServiceAccess = retrofit.create(VideoServiceAccess::class.java)
        val q = search.replace(" ", "+", true)

        videoServiceAccess.restoreVideoList(
            "snippet",
            "date",
            "20",
            LocalData.YOUTUBE_API_KEY,
            YoutubeConfig.CHANNEL_ID_1,
            q

        ).enqueue(
            object : Callback<Resultado> {
                override fun onResponse(call: Call<Resultado>, response: Response<Resultado>) {
                    Log.d("resultado", "resultado: $response")
                    if (response.isSuccessful) {
                        result = response.body()!!
                        videosList = result.items

                        configRecyclerView()
                    }
                }

                override fun onFailure(call: Call<Resultado>, t: Throwable) {
                    println("testando failure")
                    t.printStackTrace()
                }
            })

    }

    fun configRecyclerView() {
        videoAdapter = VideoAdapter(videosList, this)
        recyclerVideos.setHasFixedSize(true)
        recyclerVideos.layoutManager = LinearLayoutManager(this)
        recyclerVideos.adapter = videoAdapter

        //Config event Click

        recyclerVideos.addOnItemTouchListener(
            RecyclerItemClickListener(
                this@MainActivity,
                recyclerVideos,
                object : RecyclerItemClickListener.OnItemClickListener {

                    override fun onItemClick(view: View?, position: Int) {
                        val video = videosList[position]
                        val idVideo = video.id.videoId
                        val description = video.snippet.description
                        val title = video.snippet.title
                        Log.i("Titulo:", title)
                        val publishedAt = video.snippet.publishedAt

                        val intent = Intent(this@MainActivity, PlayerActivity::class.java)
                        intent.putExtra("idVideo", idVideo)
                        intent.putExtra("description", description)
                        intent.putExtra("title", title)
                        intent.putExtra("publishedAt", publishedAt)

                        startActivity(intent)

                    }

                    override fun onItemClick(
                        parent: AdapterView<*>?,
                        view: View?,
                        position: Int,
                        id: Long
                    ) {
                        TODO("Not yet implemented")
                    }


                    override fun onLongItemClick(view: View?, position: Int) {
                        Toast.makeText(
                            this@MainActivity,
                            "Vai ser um video favorito",
                            Toast.LENGTH_SHORT
                        ).show()
                        //TODO("implementar a lista de favoritos")

                    }

                })
        )
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_main, menu)

        val item = menu?.findItem(R.id.menu_search)
        searchView.setMenuItem(item)

        return true
    }


}
