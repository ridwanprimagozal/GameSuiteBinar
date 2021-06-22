package com.ripigo.gamesuitebinar.ui.gameplay

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.ripigo.gamesuitebinar.R
import com.ripigo.gamesuitebinar.databinding.ActivityMainBinding
import com.ripigo.gamesuitebinar.enum.CharacterGameSuit
import kotlin.random.Random

class GameActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val TAG = GameActivity::class.java.simpleName


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindViews()
        supportActionBar?.hide()
        setClickEvent()

    }

    private fun bindViews() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun setClickEvent() {


        binding.flPlayerActionRock.setOnClickListener {
            gamePlay(0, Random.nextInt(0, 3))
            Log.d(TAG, "clickAction player choice: Rock")
        }
        binding.flPlayerActionPaper.setOnClickListener {
            gamePlay(1, Random.nextInt(0, 3))
            Log.d(TAG, "clickAction player choice: Paper")
        }
        binding.flPlayerActionScissor.setOnClickListener {
            gamePlay(2, Random.nextInt(0, 3))
            Log.d(TAG, "clickAction player choice: Scissor")
        }
        binding.ivButtonRestart.setOnClickListener {
            restartGame()
            Log.d(TAG, "clickAction player choice: Restart Button")
        }
    }

    private fun gamePlay(playerSuit: Int, comSuit: Int) {

       if ((playerSuit.plus(1)).rem(3) == comSuit) {
            binding.ivStatusResult.setImageResource(R.drawable.img_winner_com)
            Log.d(TAG, "resultSuit com winner")
        } else if (playerSuit.equals(comSuit)) {
            binding.ivStatusResult.setImageResource(R.drawable.img_draw)
            Log.d(TAG, "resultSuit com and player draw")
        } else {
            binding.ivStatusResult.setImageResource(R.drawable.img_winner_player)
            Log.d(TAG, "resultSuit player winner")

        }
        setClicksListenerPlayer(playerSuit)
        setClicksListenerCom(comSuit)

    }

    private fun setClicksListenerPlayer(playerSuit: Int) {

        when (CharacterGameSuit.formInt(playerSuit)) {
            CharacterGameSuit.ROCK -> {
                binding.flPlayerActionRock.setBackgroundColor(R.drawable.imageview_button_active_background)
                binding.flPlayerActionPaper.setBackgroundColor(0)
                binding.flPlayerActionScissor.setBackgroundColor(0)
            }
            CharacterGameSuit.PAPER -> {
                binding.flPlayerActionPaper.setBackgroundColor(R.drawable.imageview_button_active_background)
                binding.flPlayerActionRock.setBackgroundColor(0)
                binding.flPlayerActionScissor.setBackgroundColor(0)
            }
            CharacterGameSuit.SCISSOR -> {
                binding.flPlayerActionScissor.setBackgroundColor(R.drawable.imageview_button_active_background)
                binding.flPlayerActionRock.setBackgroundColor(0)
                binding.flPlayerActionPaper.setBackgroundColor(0)
            } else -> {
            binding.ivStatusResult.setImageResource(0)
            binding.ivStatusResult.setImageResource(0)
            binding.ivStatusResult.setImageResource(0)

            binding.flPlayerActionRock.setBackgroundColor(0)
            binding.flPlayerActionPaper.setBackgroundColor(0)
            binding.flPlayerActionScissor.setBackgroundColor(0)

        }


        }

    }

    private fun setClicksListenerCom(comSuit: Int) {

        when (CharacterGameSuit.formInt(comSuit)) {
            CharacterGameSuit.ROCK -> {
                binding.flComActionRock.setBackgroundColor(R.drawable.imageview_button_active_background)
                binding.flComActionPaper.setBackgroundColor(0)
                binding.flComActionScissors.setBackgroundColor(0)
            }
            CharacterGameSuit.PAPER -> {
                binding.flComActionPaper.setBackgroundColor(R.drawable.imageview_button_active_background)
                binding.flComActionRock.setBackgroundColor(0)
                binding.flComActionScissors.setBackgroundColor(0)
            }
            CharacterGameSuit.SCISSOR -> {
                binding.flComActionScissors.setBackgroundColor(R.drawable.imageview_button_active_background)
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
        setClicksListenerPlayer(-1)
        setClicksListenerCom(-1)
        binding.ivStatusResult.setImageResource(R.drawable.img_vs_begin)

    }


}