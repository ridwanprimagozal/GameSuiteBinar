package com.ripigo.gamesuitebinar.ui.intro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.ripigo.gamesuitebinar.databinding.ActivityIntroSliderBinding

class IntroSliderActivity : AppCompatActivity() {

    private lateinit var binding: ActivityIntroSliderBinding
    private var fragmentList = ArrayList<Fragment>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityIntroSliderBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar!!.hide()

        val adapter = IntroSliderAdapter(this)
        binding.vpIntroSlider.adapter = adapter

        fragmentList.addAll(listOf(
            IntroOneFragment(),IntroTwoFragment(),IntroTriFragment()
        ))
        adapter.setFragmentList(fragmentList)

        binding.indicatorLayout.setIndicatorCount(adapter.itemCount)
        binding.indicatorLayout.selectCurrentPosition(0)

        registerListeners()
    }

    private fun registerListeners(){
        binding.vpIntroSlider.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){

            override fun onPageSelected(position: Int) {
                binding.indicatorLayout.selectCurrentPosition(position)
                if (position < fragmentList.lastIndex) {
                    binding.tvNext.text = "Next"
                } else {
                    binding.tvNext.visibility = View.GONE
                    //binding.tvGetStarted.text ="Get Started"
                }
            }
        })



        binding.tvNext.setOnClickListener {
            val position = binding.vpIntroSlider.currentItem
            if (position < fragmentList.lastIndex) {
                binding.vpIntroSlider.currentItem = position + 1
            }else {
                finish()
            }
        }

    }


}