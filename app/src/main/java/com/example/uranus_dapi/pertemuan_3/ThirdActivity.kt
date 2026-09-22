package com.example.uranus_dapi.pertemuan_3

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.uranus_dapi.R
import com.example.uranus_dapi.databinding.ActivityThirdBinding
import com.example.uranus_dapi.pertemuan_4.FourthActivity

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

        binding.btnToFourth.setOnClickListener {
            val no = binding.inputNoTujuan.text.toString()

            Log.d("Klik btnToFourth", "Tombol berpindah ke FourthActivity. Nomor = $no")
            Toast.makeText(this@ThirdActivity, "Membuka FourthActivity", Toast.LENGTH_SHORT).show()

            val intent = Intent(this@ThirdActivity, FourthActivity::class.java).apply {
                putExtra("EXTRA_NO_TUJUAN", no)
            }
            startActivity(intent)
        }
    }
}