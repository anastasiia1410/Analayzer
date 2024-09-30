package com.example.analayzer.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.analayzer.data.db.entity.MessageDatabase

@Database(entities = [MessageDatabase::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun messageDao(): MessageDao
}