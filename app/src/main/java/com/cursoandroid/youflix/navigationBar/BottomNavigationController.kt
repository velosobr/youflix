package com.cursoandroid.youflix.navigationBar

import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.FragmentTransaction

interface BottomNavigationController {
    fun onViewCreated(
        transaction: FragmentTransaction
    )

}
