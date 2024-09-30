package com.example.analayzer.data.db

import com.example.analayzer.entity.Message

interface DatabaseRepository {
    suspend fun insert(message: Message)


}