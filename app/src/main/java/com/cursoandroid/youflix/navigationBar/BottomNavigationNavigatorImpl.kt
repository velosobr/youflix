package com.cursoandroid.youflix.navigationBar

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import com.cursoandroid.youflix.R
import com.cursoandroid.youflix.navigationBar.videosScreen.view.VideosScreenFragment
import com.cursoandroid.youflix.navigationBar.favoriteVideos.fragment.FavoriteVideosFragment
import java.lang.ref.WeakReference

class BottomNavigationNavigatorImpl(private val weakReference: WeakReference<AppCompatActivity>) :
    BottomNavigationNavigator {
    override fun loadVideosScreenFragment() {
        weakReference.get()?.supportFragmentManager?.beginTransaction()?.replace(
            R.id.fragment_container,
            VideosScreenFragment()
        )?.commit()
    }

    override fun loadFavoriteVideosFragment(
    ) {
        weakReference.get()?.supportFragmentManager?.beginTransaction()
            ?.replace(R.id.fragment_container, FavoriteVideosFragment())?.commit()

    }
}
