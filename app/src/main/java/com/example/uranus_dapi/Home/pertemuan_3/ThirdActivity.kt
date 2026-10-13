package com.example.uranus_dapi.Home.pertemuan_3

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.uranus_dapi.BaseActivity
import com.example.uranus_dapi.databinding.ActivityThirdBinding
import com.example.uranus_dapi.Home.pertemuan_4.FourthActivity

// 1. Ubah AppCompatActivity menjadi BaseActivity
class ThirdActivity : BaseActivity() {

    private lateinit var thirdBinding: ActivityThirdBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 2. Inflate layout activity_third ke dalam fragment_container milik BaseActivity
        thirdBinding = ActivityThirdBinding.inflate(layoutInflater)
        binding.fragmentContainer.addView(thirdBinding.root)

        // 3. Logic tombol berpindah ke FourthActivity
        thirdBinding.btnToFourth.setOnClickListener {
            val no = thirdBinding.inputNoTujuan.text.toString()

            Log.d("Klik btnToFourth", "Tombol berpindah ke FourthActivity. Nomor = $no")
            Toast.makeText(this@ThirdActivity, "Membuka FourthActivity", Toast.LENGTH_SHORT).show()

            val intent = Intent(this@ThirdActivity, FourthActivity::class.java).apply {
                putExtra("EXTRA_NO_TUJUAN", no)
            }
            startActivity(intent)
        }
    }
}