package com.example.uranus_dapi.Home.pertemuan_4

import android.os.Bundle
import android.util.Log
import com.example.uranus_dapi.BaseActivity
import com.example.uranus_dapi.databinding.ActivityFourthBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.snackbar.Snackbar

// 1. Ubah warisan dari AppCompatActivity menjadi BaseActivity
class FourthActivity : BaseActivity() {

    private lateinit var fourthBinding: ActivityFourthBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 2. Inflate layout activity_fourth ke dalam fragment_container milik BaseActivity
        fourthBinding = ActivityFourthBinding.inflate(layoutInflater)
        binding.fragmentContainer.addView(fourthBinding.root)

        Log.e("onCreate", "FourthActivity dibuat pertama kali")

        // 3. Ambil data intent dari HomeFragment
        val name = intent.getStringExtra("name")
        val from = intent.getStringExtra("from")
        val age = intent.getIntExtra("age", 0)
        Log.e("Data Intent", "Nama: $name , Usia: $age, Asal: $from")

        // Tombol untuk menampilkan Snackbar
        fourthBinding.btnShowSnackbar.setOnClickListener {
            Snackbar.make(fourthBinding.root, "Ini adalah Snackbar", Snackbar.LENGTH_SHORT)
                .setAction("Tutup") {
                    Log.e("Info Snackbar", "Snackbar ditutup")
                }
                .show()
        }

        // Tombol untuk menampilkan MaterialAlertDialog
        fourthBinding.btnShowAlertDialog.setOnClickListener {
            MaterialAlertDialogBuilder(this)
                .setTitle("Konfirmasi")
                .setMessage("Apakah Anda yakin ingin melanjutkan?")
                .setPositiveButton("Ya") { dialog, _ ->
                    dialog.dismiss()
                    Log.e("Info Dialog", "Anda memilih Ya!")
                }
                .setNegativeButton("Batal") { dialog, _ ->
                    dialog.dismiss()
                    Log.e("Info Dialog", "Anda memilih Tidak!")
                }
                .show()
        }

        // Tombol kembali untuk menutup FourthActivity
        fourthBinding.btnKembali.setOnClickListener {
            finish()
        }
    }

    override fun onStart() {
        super.onStart()
        Log.e("onStart", "onStart: FourthActivity terlihat di layar")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("onDestroy", "FourthActivity dihapus dari stack")
    }
}