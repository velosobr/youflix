package com.cursoandroid.youflix.navigationBar

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.cursoandroid.youflix.R
import com.cursoandroid.youflix.navigationBar.favoriteVideos.fragment.FavoriteVideosFragment
import com.cursoandroid.youflix.navigationBar.videosScreen.view.VideosScreenFragment
import kotlinx.android.synthetic.main.activity_bottom_navigation.*

class BottomNavigationActivity : AppCompatActivity() {
    private lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_navigation)

        toolbar = findViewById(R.id.toolbar)
        toolbar.title = "YouFlix"

        setSupportActionBar(toolbar)

        setNavigationListener()

        bottom_navigation.selectedItemId = R.id.nav_videos

//        supportFragmentManager.beginTransaction().add(
//            R.id.fragment_container,
//            VideosScreenFragment()
//        ).commit()

    }

    private fun setNavigationListener() {

        bottom_navigation.setOnNavigationItemSelectedListener { item ->
            var selectedFragment: Fragment? = null

            when (item.itemId) {
                R.id.nav_videos -> selectedFragment =
                    VideosScreenFragment()
                R.id.nav_favorites -> selectedFragment =
                    FavoriteVideosFragment()
            }

            supportFragmentManager.beginTransaction()
                .setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out).replace(
                    R.id.fragment_container, selectedFragment!!
                ).commitAllowingStateLoss()

            true
        }
    }


}
