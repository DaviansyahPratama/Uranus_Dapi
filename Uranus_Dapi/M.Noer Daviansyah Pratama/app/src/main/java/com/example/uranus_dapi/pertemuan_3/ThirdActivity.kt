package com.example.uranus_dapi.pertemuan_3

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.uranus_dapi.R
import com.example.uranus_dapi.databinding.ActivityThirdBinding

class ThirdActivity : AppCompatActivity() {
    private lateinit var binding: ActivityThirdBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityThirdBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


//        val btnKirim: Button = findViewById(R.id.btnKirim)
//        val inputNoTujuan: EditText = findViewById(R.id.inputNoTujuan)


        binding.btnKirim.setOnClickListener {
            val no = binding.inputNoTujuan.text.toString()

            Log.d("Klik btnKirim", "Tombol berhasil ditekan. Isi dari inputNoTujuan = $no")

            // Menyiapkan Intent untuk berpindah ke ThirdResultActivity
            val intent = Intent(this@ThirdActivity, ThirdResultActivity::class.java).apply {
                // (Opsional) Mengirimkan data inputNoTujuan ke activity tujuan
                putExtra("NO_TUJUAN", no)
            }

            // Memanggil activity tujuan
            startActivity(intent)
        }
    }
}