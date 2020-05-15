package com.cursoandroid.youflix.navigationBar

import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import com.cursoandroid.youflix.R
import com.cursoandroid.youflix.navigationBar.VideosScreen.fragment.VideosScreenFragment

class BottomNavigationActivity : AppCompatActivity() {
    private val videosScreenFragment = VideosScreenFragment()
    private val navigator = BottomNavigationNavigatorImpl(videosScreenFragment)
    private val controller = BottomNavigationControllerImpl(navigator, this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_navigation)
        val transaction = supportFragmentManager.beginTransaction()


        controller.onViewCreated(transaction, videosScreenFragment)

    }

}
