package com.dino.kidsq.splash

import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.dino.kidsq.R
import com.dino.kidsq.databinding.ActivitySplashBinding
import com.dino.kidsq.game.HomeActivity

class SplashActivity : AppCompatActivity() {

    private lateinit var binding : ActivitySplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_splash)
        navigateToGame()
        setStatusIconColors()
    }

    private fun navigateToGame() {
        Handler().postDelayed(
            {
                val i = Intent(this, HomeActivity::class.java)
                startActivity(i)
                finish()
            }, 1500)
    }

    /**
     * Make status bar transparent
     */
    private fun setStatusIconColors() {
        window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN)
        window.statusBarColor = Color.parseColor("#2196F3")
    }
}
