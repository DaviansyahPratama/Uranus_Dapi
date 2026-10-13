package com.example.uranus_dapi

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.bumptech.glide.Glide
import com.example.uranus_dapi.databinding.ItemMessageBinding
import com.google.android.material.snackbar.Snackbar

class MessageAdapter(
    context: Context,
    private val messages: List<MessageModel>
) : ArrayAdapter<MessageModel>(context, 0, messages) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val binding: ItemMessageBinding = if (convertView == null) {
            ItemMessageBinding.inflate(LayoutInflater.from(context), parent, false)
        } else {
            ItemMessageBinding.bind(convertView)
        }

        val data = messages[position]

        // Load Gambar Profil dengan Glide
        Glide.with(context)
            .load(data.avatarUrl)
            .placeholder(android.R.drawable.ic_menu_gallery)
            .error(android.R.drawable.ic_delete)
            .into(binding.avatarImg)

        // Set Nama Pengirim
        binding.textSender.text = data.senderName

        // WAJIB: Update textAge secara dinamis dari data.age!
        binding.textAge.text = "${data.age} thn"

        // Set Isi Pesan
        binding.textMessage.text = data.messageText

        // Event Klik Item menampilkan Snackbar
        binding.root.setOnClickListener {
            Snackbar.make(
                parent,
                "Pesan dari ${data.senderName} (${data.age} tahun): ${data.messageText}",
                Snackbar.LENGTH_SHORT
            ).show()
        }

        return binding.root
    }
}