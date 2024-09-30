package com.example.analayzer.entity

data class Message(
    val updateId: Long,
    val date: Long,
    val text: String,
    val id: Long,
    val isBot: Boolean,
    val firstName: String,
    val username: String,
    val languageCode: String,
)
