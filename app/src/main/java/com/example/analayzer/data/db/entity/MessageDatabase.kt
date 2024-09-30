package com.example.analayzer.data.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.analayzer.entity.Message

@Entity(tableName = "User")
data class MessageDatabase(
    @PrimaryKey(false)
    val updateId: Long,
    val date: Long,
    val text: String,
    val id: Long,
    val isBot: Boolean,
    val firstName: String,
    val username: String,
    val languageCode: String,
)

fun MessageDatabase.toMessage(): Message {
    return Message(
        updateId = updateId,
        date = date,
        text = text,
        id = id,
        isBot = isBot,
        firstName = firstName,
        username = username,
        languageCode = languageCode
    )
}

fun Message.toMessageDatabase(): MessageDatabase {
    return MessageDatabase(
        updateId = updateId,
        date = date,
        text = text,
        id = id,
        isBot = isBot,
        firstName = firstName,
        username = username,
        languageCode = languageCode
    )
}



