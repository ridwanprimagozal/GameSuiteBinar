package com.ripigo.gamesuitebinar.ui.gameplay

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.ripigo.gamesuitebinar.R
import com.ripigo.gamesuitebinar.data.preference.UserPreference
import com.ripigo.gamesuitebinar.databinding.ActivityGameComBinding
import com.ripigo.gamesuitebinar.enum.CharacterGameSuit
import com.ripigo.gamesuitebinar.ui.dialog.DialogCustomComFragment
import com.ripigo.gamesuitebinar.ui.menu.MenuActivity
import kotlin.random.Random

class GameComActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGameComBinding
    private val TAG = GameComActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindViews()
        supportActionBar?.hide()
        setClickEvent()

    }

    private fun bindViews() {
        binding = ActivityGameComBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setTitlePlayer()
    }

    private fun setTitlePlayer(){
        binding.tvPlayer.text = String.format(
            getString(
                R.string.text_title_player_one_game,
                UserPreference(this).userName
            )
        )
    }

    private fun setClickEvent() {


        binding.flPlayerOneActionRock.setOnClickListener {
            gamePlay(0, Random.nextInt(0, 3))
            Log.d(TAG, "clickAction player choice: Rock")
        }
        binding.flPlayerOneActionPaper.setOnClickListener {
            gamePlay(1, Random.nextInt(0, 3))
            Log.d(TAG, "clickAction player choice: Paper")
        }
        binding.flPlayerOneActionScissor.setOnClickListener {
            gamePlay(2, Random.nextInt(0, 3))
            Log.d(TAG, "clickAction player choice: Scissor")
        }
        binding.ivButtonRestart.setOnClickListener {
            restartGame()
            Log.d(TAG, "clickAction player choice: Restart Button")
        }
        binding.ivBtnClose.setOnClickListener{
            closeGame()
            Log.d(TAG, "clickAction player choice: Close Button")
        }


    }

    private fun gamePlay(playerSuitOne: Int, comSuit: Int) {


        if ((playerSuitOne.plus(1)).rem(3) == comSuit) {
            binding.ivStatusResult.setImageResource(R.drawable.img_winner_com)
            DialogCustomComFragment(getString(R.string.text_vscom_com_winner)).show(supportFragmentManager, null)
            Log.d(TAG, "resultSuit com winner")
        } else if (playerSuitOne.equals(comSuit)) {
            binding.ivStatusResult.setImageResource(R.drawable.img_draw)
            DialogCustomComFragment(getString(R.string.text_vscom_com_player_draw)).show(supportFragmentManager, null)
            Log.d(TAG, "resultSuit player and com draw")
        } else {
            binding.ivStatusResult.setImageResource(R.drawable.img_winner_player)
            DialogCustomComFragment( UserPreference(this).userName + getString(R.string.text_vscom_player_winner)).show(supportFragmentManager, null)
            Log.d(TAG, "resultSuit player winner")
        }

        setClicksListenerPlayerOne(playerSuitOne)
        setClicksListenerCom(comSuit)

    }

    private fun setClicksListenerPlayerOne(playerSuitOne: Int) {


        when (CharacterGameSuit.formInt(playerSuitOne)) {
            CharacterGameSuit.ROCK -> {
                binding.flPlayerOneActionRock.setBackgroundColor(
                    ContextCompat.getColor(
                        this,
                        R.color.primary_color_variant
                    )
                )
                Toast.makeText(
                    this,
                    "you're " + UserPreference(this).userName + " choosen rock",
                    Toast.LENGTH_SHORT
                ).show()
                binding.flPlayerOneActionPaper.setBackgroundColor(0)
                binding.flPlayerOneActionScissor.setBackgroundColor(0)

            }
            CharacterGameSuit.PAPER -> {
                binding.flPlayerOneActionPaper.setBackgroundColor(
                    ContextCompat.getColor(
                        this,
                        R.color.primary_color_variant
                    )
                )
                Toast.makeText(
                    this,
                    "you're " + UserPreference(this).userName + " choosen paper",
                    Toast.LENGTH_SHORT
                ).show()
                binding.flPlayerOneActionRock.setBackgroundColor(0)
                binding.flPlayerOneActionScissor.setBackgroundColor(0)
            }
            CharacterGameSuit.SCISSOR -> {
                binding.flPlayerOneActionScissor.setBackgroundColor(
                    ContextCompat.getColor(
                        this,
                        R.color.primary_color_variant
                    )
                )
                Toast.makeText(
                    this,
                    "you're " + UserPreference(this).userName + " choosen scissor",
                    Toast.LENGTH_SHORT
                ).show()
                binding.flPlayerOneActionRock.setBackgroundColor(0)
                binding.flPlayerOneActionPaper.setBackgroundColor(0)
            } else -> {
            binding.ivStatusResult.setImageResource(0)
            binding.ivStatusResult.setImageResource(0)
            binding.ivStatusResult.setImageResource(0)

            binding.flPlayerOneActionRock.setBackgroundColor(0)
            binding.flPlayerOneActionPaper.setBackgroundColor(0)
            binding.flPlayerOneActionScissor.setBackgroundColor(0)

        }

        }

    }

    private fun setClicksListenerCom(comSuit: Int) {

        when (CharacterGameSuit.formInt(comSuit)) {
            CharacterGameSuit.ROCK -> {
                binding.flComActionRock.setBackgroundColor(
                    ContextCompat.getColor(
                        this,
                        R.color.primary_color_variant
                    )
                )
                Toast.makeText(
                    this,
                    "COM " + " choosen rock",
                    Toast.LENGTH_SHORT
                ).show()
                binding.flComActionPaper.setBackgroundColor(0)
                binding.flComActionScissors.setBackgroundColor(0)
            }
            CharacterGameSuit.PAPER -> {
                binding.flComActionPaper.setBackgroundColor(
                    ContextCompat.getColor(
                        this,
                        R.color.primary_color_variant
                    )
                )
                Toast.makeText(
                    this,
                    "COM " + " choosen paper",
                    Toast.LENGTH_SHORT
                ).show()
                binding.flComActionRock.setBackgroundColor(0)
                binding.flComActionScissors.setBackgroundColor(0)
            }
            CharacterGameSuit.SCISSOR -> {
                binding.flComActionScissors.setBackgroundColor(
                    ContextCompat.getColor(
                        this,
                        R.color.primary_color_variant
                    )
                )
                Toast.makeText(
                    this,
                    "COM " + " choosen scissor",
                    Toast.LENGTH_SHORT
                ).show()
                binding.flComActionRock.setBackgroundColor(0)
                binding.flComActionPaper.setBackgroundColor(0)
            }
            else -> {
                binding.ivStatusResult.setImageResource(0)
                binding.flComActionRock.setBackgroundColor(0)
                binding.flComActionPaper.setBackgroundColor(0)
                binding.flComActionScissors.setBackgroundColor(0)
            }
        }

    }

    private fun restartGame() {
        setClicksListenerPlayerOne(-1)
        setClicksListenerCom(-1)
        binding.ivStatusResult.setImageResource(R.drawable.img_vs_begin)

    }

    private fun closeGame() {
        startActivity(Intent(this, MenuActivity::class.java))
    }


}