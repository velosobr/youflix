package com.cursoandroid.youflix.navigationBar

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.cursoandroid.youflix.R
import com.cursoandroid.youflix.navigationBar.listVideos.view.VideoGroupListFragment

class BottomNavigationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_navigation)

        setNavigationListener()

        supportFragmentManager.beginTransaction().replace(
            R.id.fragment_container,
            VideoGroupListFragment()
        ).commit()

    }


    private fun setNavigationListener() {
        TODO("Not yet implemented")
    }
}
