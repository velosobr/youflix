package com.cursoandroid.youflix.SplashScreen

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.cursoandroid.youflix.Activity.LoginActivity
import com.cursoandroid.youflix.Activity.MainActivity
import com.cursoandroid.youflix.R

class SplashScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        val handler = Handler()

        handler.postDelayed({
            run {
                showMainActivity()
            }
        }, 2000)
    }

    private fun mostrarLogin() {
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish()

    }

    private fun showMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()

    }
}
