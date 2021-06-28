package com.ripigo.gamesuitebinar.ui.gameplay

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.ripigo.gamesuitebinar.R
import com.ripigo.gamesuitebinar.data.Controller.Callback
import com.ripigo.gamesuitebinar.data.Controller.Controller
import com.ripigo.gamesuitebinar.data.preference.UserPreference
import com.ripigo.gamesuitebinar.databinding.ActivityGamePlayerBinding
import com.ripigo.gamesuitebinar.ui.dialog.DialogCustomPlayerFragment
import com.ripigo.gamesuitebinar.ui.menu.MenuActivity


class GamePlayerActivity : AppCompatActivity(), Callback {
    private lateinit var binding : ActivityGamePlayerBinding
    private val TAG = GamePlayerActivity::class.java.simpleName
    private lateinit var playerSuitOne: String
    private lateinit var playerSuitTwo: String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGamePlayerBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar!!.hide()
        setTitlePlayer()

        playerSuitOne = toString()
        playerSuitTwo = toString()

        clickOnListenerPlayerOne()
        clickOnListenerPlayerTwo()
        btnRegister()


    }

    private fun clickOnListenerPlayerOne(){
        binding.ivRockLeft.setOnClickListener {
            playerSuitOne= "Rock"
            binding.flPlayerOneActionRock.setBackgroundColor(
                ContextCompat.getColor(
                    this,
                    R.color.primary_color_variant
                )
            )
            Toast.makeText(
                this,
                UserPreference(this).userName + " Chosen Rock",
                Toast.LENGTH_SHORT
            ).show()
            binding.ivRockLeft.isEnabled = false
            binding.ivScissorsLeft.isEnabled = false
            binding.ivPaperLeft.isEnabled = false
            binding.ivRockRight.isEnabled = true
            binding.ivScissorsRight.isEnabled = true
            binding.ivPaperRight.isEnabled = true
        }

        binding.ivPaperLeft.setOnClickListener {
            playerSuitOne = "Paper"
            binding.ivPaperLeft.setBackgroundColor(
                ContextCompat.getColor(
                    this,
                    R.color.primary_color_variant
                )
            )
            Toast.makeText(
                this,
                UserPreference(this).userName + " Chosen Paper",
                Toast.LENGTH_LONG
            ).show()
            binding.ivRockLeft.isEnabled = false
            binding.ivScissorsLeft.isEnabled = false
            binding.ivPaperLeft.isEnabled = false
            binding.ivRockRight.isEnabled = true
            binding.ivScissorsRight.isEnabled = true
            binding.ivPaperRight.isEnabled = true
        }

        binding.ivScissorsLeft.setOnClickListener {
            playerSuitOne = "Scissors"
            binding.ivScissorsLeft.setBackgroundColor(
                ContextCompat.getColor(
                    this,
                    R.color.primary_color_variant
                )
            )
            Toast.makeText(
                this,
                UserPreference(this).userName + " Chosen Scissor",
                Toast.LENGTH_SHORT
            ).show()
            binding.ivRockLeft.isEnabled = false
            binding.ivScissorsLeft.isEnabled = false
            binding.ivPaperLeft.isEnabled = false
            binding.ivRockRight.isEnabled = true
            binding.ivScissorsRight.isEnabled = true
            binding.ivPaperRight.isEnabled = true
        }
    }

    private fun clickOnListenerPlayerTwo(){
        val controller = Controller(this)

        binding.ivScissorsRight.setOnClickListener {
            playerSuitTwo = "Scissors"
            binding.ivScissorsRight.setBackgroundColor(
                ContextCompat.getColor(
                    this,
                    R.color.primary_color_variant
                )
            )
            Toast.makeText(
                this,
                "Player 2 Chosen Scissor",
                Toast.LENGTH_SHORT
            ).show()
            controller.rules(playerSuitOne, playerSuitTwo)
        }

        binding.ivRockRight.setOnClickListener {
            playerSuitTwo = "Rock"
            binding.ivRockRight.setBackgroundColor(
                ContextCompat.getColor(
                    this,
                    R.color.primary_color_variant
                )
            )
            Toast.makeText(
                this,
                "Player 2 Chosen Rock",
                Toast.LENGTH_SHORT
            ).show()
            controller.rules(playerSuitOne, playerSuitTwo)

        }

        binding.ivPaperRight.setOnClickListener {
            playerSuitTwo = "Paper"
            binding.ivPaperRight.setBackgroundColor(
                ContextCompat.getColor(
                    this,
                    R.color.primary_color_variant
                )
            )
            Toast.makeText(
                this,
                "Player 2 Chosen Paper",
                Toast.LENGTH_SHORT
            ).show()
            controller.rules(playerSuitOne, playerSuitTwo)
        }

    }

    private fun btnRegister(){
        binding.ivButtonRestart.setOnClickListener {
            binding.ivStatusResult.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.img_vs_begin))
            binding.ivRockLeft.setBackgroundColor(
                ContextCompat.getColor(
                    this,
                    R.color.primary_color_variant
                )
            )
            binding.ivScissorsLeft.setBackgroundColor(
                ContextCompat.getColor(
                    this,
                    R.color.primary_color_variant
                )
            )
            binding.ivPaperLeft.setBackgroundColor(
                ContextCompat.getColor(
                    this,
                    R.color.primary_color_variant
                )
            )
            binding.ivRockRight.setBackgroundColor(
                ContextCompat.getColor(
                    this,
                    R.color.primary_color_variant
                )
            )
            binding.ivScissorsRight.setBackgroundColor(
                ContextCompat.getColor(
                    this,
                    R.color.primary_color_variant
                )
            )
            binding.ivPaperRight.setBackgroundColor(
                ContextCompat.getColor(
                    this,
                    R.color.primary_color_variant
                )
            )
            binding.ivRockLeft.isEnabled = true
            binding.ivScissorsLeft.isEnabled = true
            binding.ivPaperLeft.isEnabled = true
            binding.ivRockRight.isEnabled = true
            binding.ivScissorsRight.isEnabled = true
            binding.ivPaperRight.isEnabled = true

        }

        binding.ivBtnClose.setOnClickListener {
            closeGame()
        }

        binding.ivButtonRestart.setOnClickListener{
            restartGame()
        }
    }


    private fun setTitlePlayer(){
        binding.tvPlayerOne.text = String.format(
            getString(
                R.string.text_title_player_one_game,
                UserPreference(this).userName
            )
        )
    }

    private fun closeGame() {
        startActivity(Intent(this, MenuActivity::class.java))
    }

    private fun restartGame() {

        binding.ivStatusResult.setImageResource(R.drawable.img_vs_begin)
        finish()
        startActivity(Intent(this,GamePlayerActivity::class.java))

    }


    override fun sendStatus(status: String) {
        when {
            status.contains("1") -> {
                binding.ivStatusResult.setImageResource(R.drawable.ic_player_one_win)
                DialogCustomPlayerFragment( UserPreference(this).userName + "\nWINNER").show(supportFragmentManager, null)
            }

            status.contains("2") -> {
                binding.ivStatusResult.setImageResource(R.drawable.ic_player_two_win)
                DialogCustomPlayerFragment("Player 2 \nWINNER").show(supportFragmentManager, null)
            }

            status.contains("w") -> {
                binding.ivStatusResult.setImageResource(R.drawable.img_draw)
                DialogCustomPlayerFragment("DRAW").show(supportFragmentManager, null)
            }
        }

    }


    }





