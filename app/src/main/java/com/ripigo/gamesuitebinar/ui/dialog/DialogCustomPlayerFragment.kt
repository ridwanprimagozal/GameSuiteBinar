package com.ripigo.gamesuitebinar.ui.dialog

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.ripigo.gamesuitebinar.R
import com.ripigo.gamesuitebinar.databinding.FragmentDialogCustomPlayerBinding
import com.ripigo.gamesuitebinar.ui.gameplay.GamePlayerActivity
import com.ripigo.gamesuitebinar.ui.intro.IntroSliderActivity
import com.ripigo.gamesuitebinar.ui.menu.MenuActivity

class DialogCustomPlayerFragment(private val message :String)  : DialogFragment() {
    private lateinit var binding: FragmentDialogCustomPlayerBinding
    private var timer : CountDownTimer? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDialogCustomPlayerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        dialog?.window?.setBackgroundDrawableResource(R.drawable.bg_dialog_round_white)
        super.onViewCreated(view, savedInstanceState)

        binding.tvWinner.text = message

        binding.btnReplayPlayer.setOnClickListener {
            dialog?.dismiss()
            reload()
        }


        binding.btnReturn.setOnClickListener {
            finish()
        }

    }

    private fun finish() {
        context?.startActivity(Intent(context,MenuActivity::class.java))
    }

    private fun reload(){
        context?.startActivity(Intent(context,GamePlayerActivity::class.java))
    }







}

