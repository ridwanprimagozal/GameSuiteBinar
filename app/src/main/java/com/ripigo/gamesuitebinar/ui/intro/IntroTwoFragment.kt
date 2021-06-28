package com.ripigo.gamesuitebinar.ui.intro

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ripigo.gamesuitebinar.R
import com.ripigo.gamesuitebinar.databinding.FragmentIntroTwoBinding

class IntroTwoFragment : Fragment() {
    private lateinit var binding : FragmentIntroTwoBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentIntroTwoBinding.inflate(inflater,container,false)
        return binding.root
    }

}