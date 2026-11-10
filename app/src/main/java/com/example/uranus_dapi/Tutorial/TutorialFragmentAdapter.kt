package com.example.uranus_dapi.Message.tutorial

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class TutorialFragmentAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity) {

    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> Tutorial1Fragment()
            1 -> Tutorial2Fragment()
            2 -> Tutorial3Fragment()
            else -> throw IllegalStateException("Posisi tidak valid: $position")
        }
    }
}