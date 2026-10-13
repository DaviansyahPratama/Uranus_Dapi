package com.example.uranus_dapi.Home.pertemuan_5

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.example.uranus_dapi.BaseActivity
import com.example.uranus_dapi.R
import com.example.uranus_dapi.databinding.ActivityFifthBinding

// 1. Ubah warisan dari AppCompatActivity menjadi BaseActivity
class FifthActivity : BaseActivity() {

    private lateinit var fifthBinding: ActivityFifthBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 2. Inflate layout activity_fifth ke dalam fragment_container milik BaseActivity
        fifthBinding = ActivityFifthBinding.inflate(layoutInflater)
        binding.fragmentContainer.addView(fifthBinding.root)

        // 3. Setup Toolbar/ActionBar
        setSupportActionBar(fifthBinding.toolbar)

        supportActionBar?.apply {
            title = "Activity Fifth"
            subtitle = "Ini adalah subtitle"
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
            setHomeAsUpIndicator(R.drawable.baseline_arrow_back_24)
        }

        // 4. Tombol untuk membuka WebViewActivity
        fifthBinding.btnWebView.setOnClickListener {
            val intent = Intent(this, WebViewActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {

            android.R.id.home -> {
                onBackPressedDispatcher.onBackPressed()
                true
            }

            R.id.action_search -> {
                Toast.makeText(
                    this,
                    "Search Clicked",
                    Toast.LENGTH_SHORT
                ).show()
                true
            }

            R.id.action_settings -> {
                Toast.makeText(
                    this,
                    "Settings Clicked",
                    Toast.LENGTH_SHORT
                ).show()
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }
}