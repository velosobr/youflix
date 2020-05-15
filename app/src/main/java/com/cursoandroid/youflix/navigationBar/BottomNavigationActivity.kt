package com.cursoandroid.youflix.navigationBar

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.cursoandroid.youflix.R
import com.cursoandroid.youflix.navigationBar.VideosScreen.fragment.VideosScreenFragment
import com.cursoandroid.youflix.navigationBar.favoriteVideos.fragment.FavoriteVideosFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_bottom_navigation.*

class BottomNavigationActivity : AppCompatActivity() {
    private val navigator = BottomNavigationNavigatorImpl()
    private val controller = BottomNavigationControllerImpl(navigator)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_navigation)

        setNavigationListener()

        controller.onViewCreated(
            supportFragmentManager.beginTransaction()
        )

    }

    private fun setNavigationListener() {
        val bottomNavigation: BottomNavigationView = bottom_navigation

        bottomNavigation.setOnNavigationItemSelectedListener { item ->
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
