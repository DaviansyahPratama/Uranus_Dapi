package com.example.uranus_dapi.Message

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.uranus_dapi.MessageAdapter
import com.example.uranus_dapi.Message.tutorial.TutorialMessageActivity
import com.example.uranus_dapi.R
import com.example.uranus_dapi.databinding.FragmentMessageBinding

class MessageFragment : Fragment() {

    private var _binding: FragmentMessageBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMessageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (requireActivity() as AppCompatActivity).setSupportActionBar(binding.toolbar)
        (requireActivity() as AppCompatActivity).supportActionBar?.apply {
            title = "Message"
        }
        setHasOptionsMenu(true)

        // URL Foto Wajah Manusia dari CDN Unsplash Public (Bebas Hotlink & Bebas Blokir)
        val dummyData = listOf(
            MessageModel(
                "Marc-André ter Stegen",
                "Clean sheet is our priority tonight! 🧤",
                "https://images.unsplash.com/photo-1534528741775-53994a69daeb?w=200&auto=format&fit=crop",
                32
            ),
            MessageModel(
                "Jules Koundé",
                "Defensive line is solid and ready.",
                "https://images.unsplash.com/photo-1507003211169-0a1dd7228f2d?w=200&auto=format&fit=crop",
                25
            ),
            MessageModel(
                "Pau Cubarsí",
                "Building play from the back smoothly.",
                "https://images.unsplash.com/photo-1500648767791-00dcc994a43e?w=200&auto=format&fit=crop",
                17
            ),
            MessageModel(
                "Inigo Martínez",
                "Headers and tackles are locked in.",
                "https://images.unsplash.com/photo-1472099645785-5658abf4ff4e?w=200&auto=format&fit=crop",
                33
            ),
            MessageModel(
                "Alejandro Balde",
                "Pace on the left flank is unmatched! ⚡",
                "https://images.unsplash.com/photo-1519085360753-af0119f7cbe7?w=200&auto=format&fit=crop",
                20
            ),
            MessageModel(
                "Marc Casadó",
                "Controlling the midfield tempo.",
                "https://images.unsplash.com/photo-1506794778202-cad84cf45f1d?w=200&auto=format&fit=crop",
                20
            ),
            MessageModel(
                "Pedri",
                "Hola! Ready for some Magic Tiki-Taka pass? 🪄",
                "https://images.unsplash.com/photo-1539571696357-5a69c17a67c6?w=200&auto=format&fit=crop",
                21
            ),
            MessageModel(
                "Dani Olmo",
                "Great space between the lines today!",
                "https://images.unsplash.com/photo-1522075469751-3a6694fb2f61?w=200&auto=format&fit=crop",
                26
            ),
            MessageModel(
                "Lamine Yamal",
                "Força Barça! Cutting inside to score! 💎",
                "https://images.unsplash.com/photo-1517841905240-472988babdf9?w=200&auto=format&fit=crop",
                17
            ),
            MessageModel(
                "Raphinha",
                "High pressing and relentless work rate! 🔥",
                "https://images.unsplash.com/photo-1492562080023-ab3db95bfbce?w=200&auto=format&fit=crop",
                27
            ),
            MessageModel(
                "Robert Lewandowski",
                "Targeting another hat-trick tonight! ⚽",
                "https://images.unsplash.com/photo-1501196354995-cbb51c65aaea?w=200&auto=format&fit=crop",
                36
            )
        )

        val adapter = MessageAdapter(requireContext(), dummyData)
        binding.listMessageItems.adapter = adapter
    }

    @Deprecated("Deprecated in Java")
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.message_toolbar_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    @Deprecated("Deprecated in Java")
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_tutorial -> {
                val intent = Intent(requireContext(), TutorialMessageActivity::class.java)
                startActivity(intent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}