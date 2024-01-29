package com.example.tic_tac_toe_game

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class splash_screen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        Handler().postDelayed({
            var i = Intent(this,MainActivity::class.java)
            startActivity(i)
            finish()
        },3000)
    }
}