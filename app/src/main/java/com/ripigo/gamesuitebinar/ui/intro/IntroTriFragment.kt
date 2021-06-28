package com.ripigo.gamesuitebinar.ui.intro

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import com.ripigo.gamesuitebinar.data.preference.UserPreference
import com.ripigo.gamesuitebinar.databinding.FragmentIntroTriBinding
import com.ripigo.gamesuitebinar.ui.menu.MenuActivity


class IntroTriFragment : Fragment() {
    private lateinit var binding: FragmentIntroTriBinding
    private lateinit var userPreference: UserPreference


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentIntroTriBinding.inflate(inflater,container,false)
        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpListener()
        prefilledCurrentName()
    }

    private fun prefilledCurrentName() {
        //prefiiled form with existing name when page created
        context?.let {
            userPreference = UserPreference(it)
            binding.etPlayerName.setText(userPreference.userName.orEmpty())// or empty == ""
        }
    }

    private fun validate(): Boolean{

        if (binding.etPlayerName.text.isNullOrEmpty()){
            return false
        }
            return true
    }

    private fun setUpListener(){
        binding.tvGetStarted.setOnClickListener{
            if (validate()){
                userPreference.userName = binding.etPlayerName.text.toString()
                context?.startActivity(Intent(context,MenuActivity::class.java))

            }else{
                showMessage()
            }
        }
    }

    private fun showMessage(){
        Snackbar.make(binding.root,"Masukan Data Dengan Benar",Snackbar.LENGTH_SHORT).show()
    }



}