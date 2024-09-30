package com.example.analayzer.data.db

import com.example.analayzer.data.db.entity.toMessageDatabase
import com.example.analayzer.entity.Message

class DatabaseRepositoryImpl(private val messageDao: MessageDao) :
    DatabaseRepository {
    override suspend fun insert(message: Message) {
        messageDao.insert(message.toMessageDatabase())
    }
}