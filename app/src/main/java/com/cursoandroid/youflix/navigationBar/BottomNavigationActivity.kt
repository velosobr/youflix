package com.cursoandroid.youflix.navigationBar

import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.cursoandroid.youflix.R

class BottomNavigationActivity : AppCompatActivity() {
    private val navigator = BottomNavigationNavigatorImpl(this)
    private val controller = BottomNavigationControllerImpl(navigator, this, Handler())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_navigation)

    }

}
