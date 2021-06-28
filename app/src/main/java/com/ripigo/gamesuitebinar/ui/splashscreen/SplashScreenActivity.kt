
package com.ripigo.gamesuitebinar.ui.splashscreen


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import com.ripigo.gamesuitebinar.R
import com.ripigo.gamesuitebinar.ui.intro.IntroSliderActivity


class SplashScreenActivity : AppCompatActivity() {
    private var timer : CountDownTimer? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        supportActionBar!!.hide()
        setEventSplashScreen()

    }

    override fun onDestroy() {
        super.onDestroy()
        //destroy the timer for case new activity still opened when splashscreen destoryed
        if (timer != null) {
            timer?.cancel()
            timer == null
        }
    }

    private fun setEventSplashScreen(){
        timer = object : CountDownTimer(3000,1000){
            override fun onTick(millisUntilFinished: Long){}
            override fun onFinish(){
                val intent = Intent(this@SplashScreenActivity, IntroSliderActivity::class.java)
                intent.flags= Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(intent)
                finish()
            }
        }
        timer!!.start()

    }


}