package com.example.uranus_dapi.Message.tutorial

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.uranus_dapi.databinding.ActivityTutorialMessageBinding

class TutorialMessageActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTutorialMessageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 1. Inisialisasi ViewBinding
        binding = ActivityTutorialMessageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 2. Hubungkan ViewPager2 dengan TutorialFragmentAdapter
        val adapter = TutorialFragmentAdapter(this)
        binding.tutorialMessageViewPager.adapter = adapter

        // 3. Hubungkan DotsIndicator dengan ViewPager2
        binding.dotIndicator.attachTo(binding.tutorialMessageViewPager)
    }
}