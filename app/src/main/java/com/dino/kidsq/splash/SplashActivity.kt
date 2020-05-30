package com.dino.kidsq.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.dino.kidsq.R
import com.dino.kidsq.game.HomeActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        navigateToGame()
    }

    private fun navigateToGame() {
        Handler().postDelayed(
            {
                val i = Intent(this, HomeActivity::class.java)
                startActivity(i)
                finish()
            }, 1000)
    }
}
