package com.cursoandroid.youflix.navigationBar

import androidx.fragment.app.FragmentTransaction
import com.cursoandroid.youflix.navigationBar.VideosScreen.fragment.VideosScreenFragment

interface BottomNavigationController {
    fun onViewCreated(
        transaction: FragmentTransaction,
        videosScreenFragment: VideosScreenFragment
    )

}
