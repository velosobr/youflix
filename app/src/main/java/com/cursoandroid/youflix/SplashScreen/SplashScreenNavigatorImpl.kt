package com.cursoandroid.youflix.SplashScreen

import android.content.Intent
import com.cursoandroid.youflix.Login.LoginActivity
import com.cursoandroid.youflix.navigationBar.listVideos.Activity.MainActivity

class SplashScreenNavigatorImpl(private val activity: SplashScreenActivity) :
    SplashScreenNavigator {
    override fun goToLogin() {
        val loginIntent = Intent(activity, LoginActivity::class.java)
        activity.startActivity(loginIntent)

    }

    override fun goToMain() {
        val mainIntent = Intent(activity, MainActivity::class.java)
        activity.startActivity(mainIntent)
    }
}