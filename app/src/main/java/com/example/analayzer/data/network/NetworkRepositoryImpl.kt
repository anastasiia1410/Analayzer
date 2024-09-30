package com.example.analayzer.data.network

import com.example.analayzer.data.network.entity.toMessage
import com.example.analayzer.entity.Message

class NetworkRepositoryImpl(private val api: Api) : NetworkRepository {

    override suspend fun getMessage(): List<Message> {
        return api.getMessage().result.flatMap { it.toMessage() }
    }
}
