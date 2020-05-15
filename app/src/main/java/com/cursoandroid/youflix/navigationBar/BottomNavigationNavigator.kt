package com.cursoandroid.youflix.navigationBar

import androidx.fragment.app.FragmentTransaction

interface BottomNavigationNavigator {
    fun loadVideosScreenFragment(
        transaction: FragmentTransaction
    )

    fun loadFavoriteVideosFragment(transaction: FragmentTransaction)

}
