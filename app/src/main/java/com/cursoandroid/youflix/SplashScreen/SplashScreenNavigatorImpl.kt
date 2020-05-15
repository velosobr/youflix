package com.cursoandroid.youflix.SplashScreen

import android.content.Intent
import com.cursoandroid.youflix.Login.LoginActivity
import com.cursoandroid.youflix.navigationBar.BottomNavigationActivity

//TODO: Porque uma activity precisa ser criada no construtor e um fragment não? Digo
// isso pois na classe BottomNavigationNavigatorImpl não é necessário, consigo receber por parâmetro

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