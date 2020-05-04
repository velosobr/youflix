package com.cursoandroid.youflix.SplashScreen

import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.cursoandroid.youflix.R

class SplashScreenActivity : AppCompatActivity(), SplashScreenView {

    private val navigator = SplashScreenNavigatorImpl(this)
    private val controller = SplashScreenControllerImpl(navigator, this, Handler())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        controller.onViewCreated()
    }


}
