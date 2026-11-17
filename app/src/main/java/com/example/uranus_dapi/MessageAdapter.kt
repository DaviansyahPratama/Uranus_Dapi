package com.example.uranus_dapi

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.uranus_dapi.Message.MessageModel
import com.example.uranus_dapi.databinding.ItemMessageBinding

class MessageAdapter(
    private val context: Context,
    private val messageList: List<MessageModel>
) : BaseAdapter() {

    override fun getCount(): Int = messageList.size

    override fun getItem(position: Int): Any = messageList[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val binding: ItemMessageBinding
        val view: View

        if (convertView == null) {
            binding = ItemMessageBinding.inflate(LayoutInflater.from(context), parent, false)
            view = binding.root
            view.tag = binding
        } else {
            view = convertView
            binding = view.tag as ItemMessageBinding
        }

        val item = messageList[position]

        // Set Teks
        binding.tvSenderName.text = item.senderName
        binding.tvMessageText.text = item.messageText
        binding.tvAge.text = "${item.age} thn"

        // Generasi URL Fallback Inisial Nama (Tema Blaugrana: Background Emas #EDBB00, Teks Merah #A50044)
        val fallbackUrl = "https://ui-avatars.com/api/?name=${item.senderName.replace(" ", "+")}&background=EDBB00&color=A50044&size=150"

        // Load Gambar via Glide
        Glide.with(context)
            .load(item.avatarUrl)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .placeholder(android.R.drawable.ic_menu_gallery)
            .error(
                Glide.with(context).load(fallbackUrl) // Otomatis buat avatar inisial jika URL utama gagal/terblokir
            )
            .into(binding.imgAvatar)

        return view
    }
}