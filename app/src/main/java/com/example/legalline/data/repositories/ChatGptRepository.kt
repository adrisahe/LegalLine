package com.example.legalline.data.repositories

import com.example.legalline.data.datasources.RemoteDataSource
import com.example.legalline.framework.data.datasources.ChatGptApi
import com.example.legalline.domain.makeRequest.GptSendData

class ChatGptRepository(private val remoteDataSource: RemoteDataSource) {
    fun getResponses(message: GptSendData, apiKey: String) = remoteDataSource.getResponse(message, apiKey)
}