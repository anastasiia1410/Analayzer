package com.example.analayzer.data.db

import androidx.room.Dao
import androidx.room.Insert
import com.example.analayzer.data.db.entity.MessageDatabase

@Dao
interface MessageDao {
    @Insert
    suspend fun insert(message: MessageDatabase)

}