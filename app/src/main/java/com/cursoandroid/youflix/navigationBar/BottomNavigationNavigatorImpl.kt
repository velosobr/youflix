package com.cursoandroid.youflix.navigationBar

import androidx.fragment.app.FragmentTransaction
import com.cursoandroid.youflix.R
import com.cursoandroid.youflix.navigationBar.VideosScreen.view.VideosScreenFragment
import com.cursoandroid.youflix.navigationBar.favoriteVideos.fragment.FavoriteVideosFragment

class BottomNavigationNavigatorImpl :
    BottomNavigationNavigator {
    override fun loadVideosScreenFragment(
        transaction: FragmentTransaction
    ) {
        transaction.replace(
            R.id.fragment_container,
            VideosScreenFragment()
        ).commit()
    }

    override fun loadFavoriteVideosFragment(
        transaction: FragmentTransaction
    ) {
        transaction.replace(R.id.fragment_container, FavoriteVideosFragment()).commit()

    }
}
