package com.example.legalline.Retrofit

import com.example.legalline.Model.Message
import com.example.legalline.Model.makeRequest.GptSendData
import com.example.legalline.Model.receiveResponse.GptResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface ChatGptApi {
    @POST("chat/completions")
    fun sendQuestion(@Body mesage: GptSendData, @Header("Authorization") apiKey: String): Call<GptResponse>

    @POST("chat/completions")
    fun lawyerMode(@Body mesage: GptSendData, @Header("Authorization") apiKey: String): Call<Void>

}