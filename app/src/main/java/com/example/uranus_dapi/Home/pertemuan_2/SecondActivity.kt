package com.example.uranus_dapi.Home.pertemuan_2

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.uranus_dapi.BaseActivity
import com.example.uranus_dapi.R

// 1. Ubah AppCompatActivity menjadi BaseActivity
class SecondActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 2. Inflate layout activity_second ke dalam fragment_container milik BaseActivity
        layoutInflater.inflate(R.layout.activity_second, binding.fragmentContainer, true)

        // 3. Inisialisasi komponen UI setelah layout dimasukkan ke fragment_container
        val btnSubmit: Button = findViewById(R.id.btnSubmit)
        val inputNama: EditText = findViewById(R.id.inputNama)

        btnSubmit.setOnClickListener {
            // Mengambil value dari inputNama dan menampilkan di Logcat
            val nama = inputNama.text
            Log.e("Klik btnSubmit", "Tombol berhasil di tekan. Isi dari inputNama = $nama")

            Toast.makeText(this, "Anda telah melakukan klik pada tombol Submit", Toast.LENGTH_SHORT).show()
        }
    }
}