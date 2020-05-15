package com.cursoandroid.youflix.navigationBar

import androidx.fragment.app.FragmentTransaction

interface BottomNavigationNavigator {
    fun loadFavoriteVideosFragment(transaction: FragmentTransaction)
    fun loadVideosScreenFragment(transaction: FragmentTransaction)
}
