package com.example.uranus_dapi

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.uranus_dapi.databinding.FragmentMessageBinding

// Model data dengan properti age
data class MessageModel(
    val senderName: String,
    val messageText: String,
    val avatarUrl: String,
    val age: Int
)

class MessageFragment : Fragment() {

    private var _binding: FragmentMessageBinding? = null
    private val binding get() = _binding!!

    // Variasikan nilai parameter umur di setiap objek MessageModel
    private val messageList = listOf(
        MessageModel("Alya", "Halo! Apa kabar?", "https://api.dicebear.com/7.x/bottts/png?seed=Alya", 20),
        MessageModel("Budi", "Sudah makan?", "https://api.dicebear.com/7.x/bottts/png?seed=Budi", 22),
        MessageModel("Citra", "Jangan lupa tugasnya ya!", "https://api.dicebear.com/7.x/bottts/png?seed=Citra", 19),
        MessageModel("Dika", "Besok kita rapat jam 9", "https://api.dicebear.com/7.x/bottts/png?seed=Dika", 25),
        MessageModel("Eka", "Nice job kemarin!", "https://api.dicebear.com/7.x/bottts/png?seed=Eka", 21),
        MessageModel("Fajar", "Lagi ngapain?", "https://api.dicebear.com/7.x/bottts/png?seed=Fajar", 24),
        MessageModel("Gita", "Boleh minta tolong?", "https://api.dicebear.com/7.x/bottts/png?seed=Gita", 23),
        MessageModel("Hana", "Lihat email ya", "https://api.dicebear.com/7.x/bottts/png?seed=Hana", 26),
        MessageModel("Irfan", "Oke noted", "https://api.dicebear.com/7.x/bottts/png?seed=Irfan", 18),
        MessageModel("Joko", "Sampai jumpa besok", "https://api.dicebear.com/7.x/bottts/png?seed=Joko", 27)
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMessageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.toolbar.title = "Message"

        val adapter = MessageAdapter(requireContext(), messageList)
        binding.listMessageItems.adapter = adapter

        binding.listMessageItems.setOnItemClickListener { _, _, position, _ ->
            val selectedMessage = messageList[position]
            Toast.makeText(
                requireContext(),
                "Pesan dari ${selectedMessage.senderName} (${selectedMessage.age} tahun): ${selectedMessage.messageText}",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}