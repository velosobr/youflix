package com.cursoandroid.youflix.Presentation.Activity

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.cursoandroid.youflix.R

class SplashScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        val handler = Handler()

        handler.postDelayed({
            run {
                mostrarLogin()
            }
        }, 2000)
    }

    private fun mostrarLogin() {
        val intent = Intent(this, playerActivity::class.java)
        startActivity(intent)
        finish()

    }
}
