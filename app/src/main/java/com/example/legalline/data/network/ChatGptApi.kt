package com.example.legalline.data.network

import com.example.legalline.domain.makeRequest.GptSendData
import com.example.legalline.domain.receiveResponse.GptResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

interface ChatGptApi {
    @POST("chat/completions")
    fun sendQuestion(@Body mesage: GptSendData, @Header("Authorization") apiKey: String): Call<GptResponse>
}