package com.example.bmi_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.content.Intent

class SplashScreen : AppCompatActivity() {

    private val SPLASH_TIME: Long = 3500

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        Handler().postDelayed( {
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }
            , SPLASH_TIME)

    }
}