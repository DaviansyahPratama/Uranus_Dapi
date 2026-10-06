package com.example.uranus_dapi

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.uranus_dapi.databinding.ActivityMainBinding
import com.example.uranus_dapi.pertemuan_4.FourthActivity
import com.example.uranus_dapi.pertemuan_5.FifthActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Log.e("onCreate", "MainActivity dibuat pertama kali")

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Akses SharedPreferences "user_pref"
        val sharedPref = getSharedPreferences("user_pref", Context.MODE_PRIVATE)

        // Klik tombol btnToFourth untuk berpindah ke FourthActivity
        binding.btnToFourth.setOnClickListener {
            val intent = Intent(this@MainActivity, FourthActivity::class.java)

            intent.putExtra("name", "Politeknik Caltex Rumbai")
            intent.putExtra("from", "Rumbai")
            intent.putExtra("age", 25)

            startActivity(intent)
        }

        binding.btnToFiftth.setOnClickListener {
            val intent = Intent(this@MainActivity, FifthActivity::class.java)
            startActivity(intent)
        }

        // Fitur Logout dengan AlertDialog & Menghapus SharedPreferences
        binding.btnLogout.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle("Konfirmasi Logout")
                .setMessage("Apakah Anda yakin ingin keluar?")
                .setPositiveButton("Ya") { dialog, _ ->
                    // 1. Hapus data session di SharedPreferences
                    val editor = sharedPref.edit()
                    editor.clear()
                    editor.apply()

                    dialog.dismiss()

                    // 2. Arahkan kembali ke AuthActivity
                    val intent = Intent(this@MainActivity, AuthActivity::class.java)
                    startActivity(intent)
                    finish() // Tutup MainActivity
                }
                .setNegativeButton("Tidak", null)
                .show()
        }
    }

    override fun onStart() {
        super.onStart()
        Log.e("onStart", "onStart: MainActivity terlihat di layar")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("onDestroy", "MainActivity dihapus dari stack")
    }
}