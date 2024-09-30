package com.example.analayzer.data.network

import com.example.analayzer.entity.Message


interface NetworkRepository {

    suspend fun getMessage(): List<Message>
}