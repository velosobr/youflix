package com.cursoandroid.youflix.SplashScreen

import android.content.Intent
import com.cursoandroid.youflix.Login.LoginActivity
import com.cursoandroid.youflix.navigationBar.BottomNavigationActivity

class SplashScreenNavigatorImpl(private val splashScreenActivity: SplashScreenActivity) :
    SplashScreenNavigator {
    override fun goToLogin() {
        val loginIntent = Intent(splashScreenActivity, LoginActivity::class.java)
        splashScreenActivity.startActivity(loginIntent)

    }

    override fun goToMain() {
        val mainIntent = Intent(splashScreenActivity, BottomNavigationActivity::class.java)
        splashScreenActivity.startActivity(mainIntent)
    }
}