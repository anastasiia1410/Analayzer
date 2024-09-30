package com.example.analayzer.screens.message

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch

class MessageFragment : Fragment() {
    private val viewModel by viewModels<MessageViewModel>()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lifecycleScope.launch {
            viewModel.messageFlow.collect {
                Toast.makeText(requireContext(), "${it?.text}", Toast.LENGTH_LONG).show()
            }
        }
    }
}