package com.example.uranus_dapi.Home.Pertemuan_6

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.uranus_dapi.BaseActivity
import com.example.uranus_dapi.R
import com.example.uranus_dapi.databinding.ActivitySixthBinding

class SixthActivity : BaseActivity() {

    private lateinit var sixthBinding: ActivitySixthBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inflate layout activity_sixth ke dalam fragmentContainer milik BaseActivity
        sixthBinding = ActivitySixthBinding.inflate(layoutInflater)
        binding.fragmentContainer.addView(sixthBinding.root)

        // Set Toolbar
        setSupportActionBar(sixthBinding.toolbar)
        supportActionBar?.apply {
            title = "Pertemuan 6"
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
        }

        // Tampilkan fragment pertama secara default
        if (savedInstanceState == null) {
            replaceInnerFragment(SatuFragment())
        }

        // Setup listener tombol pengganti fragment internal Pertemuan 6
        sixthBinding.btnFragment1.setOnClickListener {
            replaceInnerFragment(SatuFragment())
        }

        sixthBinding.btnFragment2.setOnClickListener {
            replaceInnerFragment(DuaFragment())
        }

        sixthBinding.btnFragment3.setOnClickListener {
            replaceInnerFragment(TigaFragment())
        }
    }

    // Fungsi helper khusus untuk mengganti fragment di dalam SixthActivity
    private fun replaceInnerFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.sixth_fragment_container, fragment) // <--- Gunakan ID baru agar tidak bentrok dengan BaseActivity
            .commit()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        return true
    }
}