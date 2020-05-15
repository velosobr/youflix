package com.cursoandroid.youflix.navigationBar

import androidx.fragment.app.FragmentTransaction
import com.google.android.material.bottomnavigation.BottomNavigationView

class BottomNavigationControllerImpl(
    private val navigator: BottomNavigationNavigatorImpl
) : BottomNavigationController {
    override fun onViewCreated(transaction: FragmentTransaction) {
        navigator.loadVideosScreenFragment(transaction)
    }


}
