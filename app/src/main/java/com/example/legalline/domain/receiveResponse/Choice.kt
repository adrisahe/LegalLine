package com.example.legalline.domain.receiveResponse

import com.example.legalline.domain.Message

data class Choice(
    val finish_reason: String,
    val index: Int,
    val message: Message
)