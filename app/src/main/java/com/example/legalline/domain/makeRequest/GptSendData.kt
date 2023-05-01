package com.example.legalline.domain.makeRequest

import com.example.legalline.domain.Message

data class GptSendData(
    val messages: List<Message>,
    val model: String,
    val temperature: Double
)