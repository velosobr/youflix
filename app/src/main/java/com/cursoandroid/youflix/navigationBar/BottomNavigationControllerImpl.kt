package com.cursoandroid.youflix.navigationBar

import android.os.Handler
import androidx.fragment.app.FragmentTransaction
import com.cursoandroid.youflix.navigationBar.VideosScreen.fragment.VideosScreenFragment

class BottomNavigationControllerImpl(
    private val navigator: BottomNavigationNavigatorImpl,
    bottomNavigationActivity: BottomNavigationActivity
) : BottomNavigationController {
    override fun onViewCreated(
        transaction: FragmentTransaction,
        videosScreenFragment: VideosScreenFragment
    ) {
        navigator.loadVideosScreenFragment(transaction)
    }
}
