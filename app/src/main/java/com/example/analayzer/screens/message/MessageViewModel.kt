package com.example.analayzer.screens.message

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.analayzer.data.db.DatabaseRepository
import com.example.analayzer.data.network.NetworkRepository
import com.example.analayzer.entity.Message
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class MessageViewModel (
    private val networkRepository: NetworkRepository,
    private val databaseRepository: DatabaseRepository,
) : ViewModel() {

    val messageFlow = MutableStateFlow<Message?>(null)

    init {
        getMessage()
    }


    private fun getMessage() {
        viewModelScope.launch {
            val messageList = networkRepository.getMessage()
            for (message in messageList) {
                messageFlow.value = message
                databaseRepository.insert(message)

            }
        }
    }
}