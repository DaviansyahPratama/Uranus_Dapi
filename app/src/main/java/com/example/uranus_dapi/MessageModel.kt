package com.example.uranus_dapi.Message

data class MessageModel(
    val senderName: String,
    val messageText: String,
    val avatarUrl: String, // <-- Pastikan variabel ini bernama avatarUrl
    val age: Int
)