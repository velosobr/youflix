package com.cursoandroid.youflix.navigationBar

import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.FragmentTransaction
import com.cursoandroid.youflix.R

class BottomNavigationControllerImpl(
    private val navigator: BottomNavigationNavigatorImpl
) : BottomNavigationController {
    override fun onViewCreated(
        transaction: FragmentTransaction
    ) {
        navigator.loadVideosScreenFragment(transaction)

    }


}
