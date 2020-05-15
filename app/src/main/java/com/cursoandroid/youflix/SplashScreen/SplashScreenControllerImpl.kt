package com.cursoandroid.youflix.SplashScreen

import android.os.Handler

class SplashScreenControllerImpl(
    private val navigator: SplashScreenNavigator,
    private val view: SplashScreenView,
    private val handler: Handler
) : SplashScreenController {

    override fun onViewCreated() {
        handler.postDelayed({
            navigator.goToMain()
            view.finish()
        }, 2000)

    }
}