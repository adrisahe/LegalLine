package com.example.legalline.framework.data.datasources

import android.util.Log
import com.example.legalline.data.datasources.RemoteDataSource
import com.example.legalline.domain.makeRequest.GptSendData
import com.example.legalline.domain.receiveResponse.GptResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class ServerMessageQuestionSource (private val chatGptApi: ChatGptApi): RemoteDataSource {
    override fun getResponse(mesage: GptSendData, apiKey: String): Call<GptResponse> {
        return chatGptApi.sendQuestion(mesage, apiKey)
    }
}