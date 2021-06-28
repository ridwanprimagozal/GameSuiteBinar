package com.ripigo.gamesuitebinar.ui.menu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import com.ripigo.gamesuitebinar.R
import com.ripigo.gamesuitebinar.data.preference.UserPreference
import com.ripigo.gamesuitebinar.databinding.ActivityMenuBinding
import com.ripigo.gamesuitebinar.ui.gameplay.GameComActivity
import com.ripigo.gamesuitebinar.ui.gameplay.GamePlayerActivity

class MenuActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMenuBinding
    private var selectedButton : Int = -1


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar!!.hide()
        binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setTitlePage()
        showWelcomeMessage()
        setClickListenersPlayerPlayer()

    }

    private fun setTitlePage(){
        binding.tvTitleMenu.text = String.format(
            getString(
               R.string.text_title_menu,
               UserPreference(this).userName
            )
        )

        binding.tvTitlePlayerVsPlayer.text = String.format(
            getString(
                R.string.text_menu_player_player,
                UserPreference(this).userName
            )
        )

        binding.tvTitlePlayerVsCom.text = String.format(
            getString(
                R.string.text_menu_player_com,
                UserPreference(this).userName
            )
        )

    }

    private fun showWelcomeMessage(){
        val snackBar = Snackbar.make(
            binding.root,
            getString(R.string.text_hello_snackbar) + UserPreference(this).userName,
            Snackbar.LENGTH_INDEFINITE
        )
        snackBar.setAction(getString(R.string.text_close_snackbar)){
            snackBar.dismiss()
        }
        snackBar.show()
    }

    private fun setClickListenersPlayerPlayer() {

        binding.flMenuPlayerVsCom.setOnClickListener {
            selectedButton = 1
            binding.flMenuPlayerVsCom.setBackgroundColor(R.drawable.imageview_button_active_background)
            binding.flMenuPlayerVsPlayer.setBackgroundColor(0)
            startActivity(Intent(this,GameComActivity::class.java))
        }

        binding.flMenuPlayerVsPlayer.setOnClickListener {
            selectedButton = 2
            binding.flMenuPlayerVsPlayer.setBackgroundColor(R.drawable.imageview_button_active_background)
            binding.flMenuPlayerVsCom.setBackgroundColor(0)
            startActivity(Intent(this,GamePlayerActivity::class.java))


        }



    }


}