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

        // 1. Setup Toolbar dari Layout XML
        (requireActivity() as AppCompatActivity).setSupportActionBar(binding.toolbar)
        (requireActivity() as AppCompatActivity).supportActionBar?.apply {
            title = "Message"
        }
        setHasOptionsMenu(true)

        // 2. Data dummy untuk ListView
        val dummyData = listOf(
            MessageModel("Pedri", "Hola Visca Barca!", "https://via.placeholder.com/150", 21),
            MessageModel("Gavi", "Ready for next match", "https://via.placeholder.com/150", 19),
            MessageModel("Lamine Yamal", "Força Barça!", "https://via.placeholder.com/150", 16)
        )

        // 3. Pasang Adapter ke ListView (listMessageItems)
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