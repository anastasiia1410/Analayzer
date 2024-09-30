package com.example.analayzer.data.network.entity

import com.example.analayzer.entity.Message
import com.google.gson.annotations.SerializedName

data class MessageNetwork(
    @SerializedName("ok")
    val isOk: Boolean,
    @SerializedName("result")
    val infoMessage: List<InfoMessage>,
)

data class InfoMessage(
    @SerializedName("update_id")
    val updateId: Long,
    @SerializedName("message")
    val messageQualify: MessageQualify,
    @SerializedName("chat")
    val chat: Chat,
    @SerializedName("date")
    val date: Long,
    @SerializedName("text")
    val text: String,
)

data class MessageQualify(
    @SerializedName("message_id")
    val messageId: Long,
    @SerializedName("from")
    val sender: Sender,
)

data class Sender(
    @SerializedName("id")
    val id: Long,
    @SerializedName("is_bot")
    val isBot: Boolean,
    @SerializedName("first_name")
    val firstName: String,
    @SerializedName("username")
    val username: String,
    @SerializedName("language_code")
    val languageCode: String,
)

data class Chat(
    @SerializedName("id")
    val id: Long,
    @SerializedName("first_name")
    val firstName: String,
    @SerializedName("username")
    val username: String,
    @SerializedName("type")
    val type: String,
)

fun MessageNetwork.toMessage(): List<Message> {
    return this.infoMessage.map { infoMessage ->
        Message(
            updateId = infoMessage.updateId,
            date = infoMessage.date,
            text = infoMessage.text,
            id = infoMessage.messageQualify.sender.id,
            isBot = infoMessage.messageQualify.sender.isBot,
            firstName = infoMessage.messageQualify.sender.firstName,
            username = infoMessage.messageQualify.sender.username,
            languageCode = infoMessage.messageQualify.sender.languageCode
        )
    }
}

