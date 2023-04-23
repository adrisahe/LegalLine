package com.example.legalline.Model.receiveResponse

import com.example.legalline.Model.Message

data class Choice(
    val finish_reason: String,
    val index: Int,
    val message: Message
)