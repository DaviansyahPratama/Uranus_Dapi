package com.example.uranus_dapi.Home.pertemuan_10

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class TenthTabsAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity) {

    override fun getItemCount(): Int = 3 // Jumlah tab diubah menjadi 3 (Tab A, Tab B, Tab C)

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> TabAFragment()
            1 -> TabBFragment()
            2 -> TabCFragment() // Menambahkan TabCFragment pada indeks ke-2
            else -> throw IllegalStateException("Posisi tidak valid")
        }
    }
}