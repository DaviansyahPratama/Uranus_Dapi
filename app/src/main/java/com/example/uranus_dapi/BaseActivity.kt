package com.example.uranus_dapi

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.example.uranus_dapi.databinding.ActivityBaseBinding

open class BaseActivity : AppCompatActivity() {

    // 1. Properti ViewBinding agar bisa diakses oleh Activity turunan
    protected lateinit var binding: ActivityBaseBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // 2. Inflate layout activity_base.xml
        binding = ActivityBaseBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 3. Penanganan WindowInsets (Padding bottom diubah ke 0 agar BottomNav menempel pas)
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, 0)
            insets
        }

        // 4. Set Fragment default HANYA jika ini adalah BaseActivity murni (bukan Activity turunan)
        if (savedInstanceState == null && isBaseActivity()) {
            replaceFragment(HomeFragment())
        }

        // 5. Inisialisasi listener BottomNavigationView
        setupBottomNavigation()
    }

    private fun setupBottomNavigation() {
        binding.bottomNavView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.home -> {
                    if (!isBaseActivity()) {
                        // Jika klik dari SecondActivity/FourthActivity/dll, tutup activity tersebut untuk kembali ke BaseActivity
                        finish()
                    } else {
                        // Jika sudah di BaseActivity, tampilkan HomeFragment
                        replaceFragment(HomeFragment())
                    }
                    true
                }
                R.id.message -> {
                    if (!isBaseActivity()) {
                        // Tutup sub-activity lalu berpindah ke tab Message
                        finish()
                    }
                    replaceFragment(MessageFragment())
                    true
                }
                R.id.more -> {
                    if (!isBaseActivity()) {
                        // Tutup sub-activity lalu berpindah ke tab More
                        finish()
                    }
                    replaceFragment(MoreFragment())
                    true
                }
                else -> false
            }
        }
    }

    // Pengecekan apakah Activity yang berjalan saat ini adalah BaseActivity utama
    private fun isBaseActivity(): Boolean {
        return this::class.java == BaseActivity::class.java
    }

    // Synchronize status item terpilih di BottomNavigationView
    override fun onResume() {
        super.onResume()
        if (!isBaseActivity()) {
            // Saat di sub-activity (pertemuan 2, 3, 4, 5, 6), tetap sorot ikon Home
            binding.bottomNavView.menu.findItem(R.id.home)?.isChecked = true
        }
    }

    // 6. Fungsi helper untuk mengganti Fragment di fragment_container
    protected fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}