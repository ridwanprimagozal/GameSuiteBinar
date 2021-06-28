package com.ripigo.gamesuitebinar.ui.dialog

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.ripigo.gamesuitebinar.R
import com.ripigo.gamesuitebinar.databinding.FragmentDialogCustomComBinding
import com.ripigo.gamesuitebinar.ui.gameplay.GamePlayerActivity
import com.ripigo.gamesuitebinar.ui.menu.MenuActivity


class DialogCustomComFragment(private val message :String) : DialogFragment() {



    private lateinit var binding: FragmentDialogCustomComBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDialogCustomComBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        dialog?.window?.setBackgroundDrawableResource(R.drawable.bg_dialog_round_white)
        super.onViewCreated(view, savedInstanceState)


        binding.tvWinner.text = message

        binding.btnReplayCom.setOnClickListener {
            dialog?.dismiss()
        }


        binding.btnReturn.setOnClickListener {
            finish()
        }

    }

    private fun finish() {
        context?.startActivity(Intent(context,MenuActivity::class.java))
    }


}