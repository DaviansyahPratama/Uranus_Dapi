package com.example.uranus_dapi

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.example.uranus_dapi.Home.HomeFragment
import com.example.uranus_dapi.Message.MessageFragment
import com.example.uranus_dapi.Note.NoteFragment
import com.example.uranus_dapi.databinding.ActivityBaseBinding

open class BaseActivity : AppCompatActivity() {

    protected lateinit var binding: ActivityBaseBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityBaseBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, 0)
            insets
        }

        if (savedInstanceState == null && isBaseActivity()) {
            replaceFragment(HomeFragment())
        }

        setupBottomNavigation()
    }

    private fun setupBottomNavigation() {
        binding.bottomNavView.setOnItemSelectedListener { item ->
            if (!isBaseActivity()) {
                finish()
                true
            } else {
                when (item.itemId) {
                    R.id.home -> {
                        replaceFragment(HomeFragment())
                        true
                    }
                    R.id.message -> {
                        replaceFragment(MessageFragment())
                        true
                    }
                    R.id.note -> {
                        replaceFragment(NoteFragment())
                        true
                    }
                    R.id.more -> {
                        replaceFragment(MoreFragment())
                        true
                    }
                    else -> false
                }
            }
        }
    }

    private fun isBaseActivity(): Boolean {
        return this::class.java == BaseActivity::class.java
    }

    override fun onResume() {
        super.onResume()
        if (!isBaseActivity()) {
            binding.bottomNavView.menu.findItem(R.id.home)?.isChecked = true
        }
    }

    protected fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}
