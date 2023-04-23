package com.example.legalline.Model.makeRequest

import com.example.legalline.Model.Message

data class GptSendData(
    val messages: List<Message>,
    val model: String,
    val temperature: Double
)