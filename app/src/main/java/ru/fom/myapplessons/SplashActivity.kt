package ru.fom.myapplessons

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.WindowManager
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.fragment_splash.*
import ru.fom.myapplessons.databinding.ActivitySplashBinding


class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding
    private lateinit var topAnimation: Animation
    private lateinit var bottomAnimation: Animation

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        topAnimation = AnimationUtils.loadAnimation(this, R.anim.splash_top_animation)
        bottomAnimation = AnimationUtils.loadAnimation(this, R.anim.splash_bottom_animation)

        iv_spalsh_pic.startAnimation(topAnimation)
        tv_splash_text.startAnimation(bottomAnimation)

        Handler().postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, 3000)

        if(isOnline(this)) {
            Log.d("M_connect", "ok")
        }else{
            tv_splash_text.text = "Подключение к интернету не установлено"
            Log.d("M_connect1", "not")
        }


    }

    fun isOnline(context: Context): Boolean {
        val cm = context.getSystemService(CONNECTIVITY_SERVICE) as ConnectivityManager
        val netInfo = cm.activeNetworkInfo
        return netInfo != null && netInfo.isConnectedOrConnecting
    }
}