package com.cursoandroid.youflix.navigationBar.listVideos.Activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cursoandroid.youflix.Data.API.RetrofitConfig
import com.cursoandroid.youflix.Data.API.VideoServiceAccess
import com.cursoandroid.youflix.R
import com.cursoandroid.youflix.navigationBar.listVideos.Data.LocalData
import com.cursoandroid.youflix.navigationBar.listVideos.Listeners.ItemClickListener
import com.cursoandroid.youflix.navigationBar.listVideos.adapters.MyVideoGroupAdapter
import com.cursoandroid.youflix.navigationBar.listVideos.helper.YoutubeConfig
import com.cursoandroid.youflix.navigationBar.listVideos.models.ItemData
import com.cursoandroid.youflix.navigationBar.listVideos.models.ItemGroup
import com.cursoandroid.youflix.navigationBar.listVideos.models.Resultado
import com.miguelcatalan.materialsearchview.MaterialSearchView
import com.miguelcatalan.materialsearchview.MaterialSearchView.OnQueryTextListener
import com.miguelcatalan.materialsearchview.MaterialSearchView.SearchViewListener
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class MainActivity : AppCompatActivity() {

    //widgets

    private lateinit var searchView: MaterialSearchView
    private lateinit var toolbar: Toolbar

    private lateinit var retrofit: Retrofit

    private lateinit var myRecyclerViewVideos: RecyclerView

    private var itemGroups: MutableList<ItemGroup> = mutableListOf()

    private var listResults: MutableList<Resultado> = mutableListOf()
    private lateinit var result: Resultado


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //init components
        searchView = findViewById(R.id.searchView)
        myRecyclerViewVideos = findViewById(R.id.my_recyclr_view_main)

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
            YoutubeConfig.CHANNEL_ID,
            q

        ).enqueue(
            object : Callback<Resultado> {
                override fun onResponse(call: Call<Resultado>, response: Response<Resultado>) {
                    Log.d("resultado", "resultado: $response")
                    if (response.isSuccessful) {
                        result = response.body()!!
                        itemGroups.add(ItemGroup("canal 1", result.items))

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
        val myVideoGroupAdapter = MyVideoGroupAdapter(this, itemGroups, object : ItemClickListener {
            override fun onVideoClickListener(itemData: ItemData) {
                onVideoClick(itemData)
            }

            override fun onVideoLongClickListener(itemData: ItemData) {
                Log.i("Longclick", "long click teste")
            }

        })
        //TODO: Como não enviar o itemGroups vazio?

        myRecyclerViewVideos.adapter = myVideoGroupAdapter
        myRecyclerViewVideos.setHasFixedSize(true)
        myRecyclerViewVideos.layoutManager = LinearLayoutManager(this)


    }

    fun onVideoClick(itemData: ItemData) {
        val intent = Intent(this@MainActivity, PlayerActivity::class.java)
        intent.putExtra("idVideo", itemData.id.videoId)
        intent.putExtra("description", itemData.snippet.description)
        intent.putExtra("title", itemData.snippet.title)
        intent.putExtra("publishedAt", itemData.snippet.publishedAt)

        startActivity(intent)

    }



    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_main, menu)

        val item = menu?.findItem(R.id.menu_search)
        searchView.setMenuItem(item)

        return true
    }


}
