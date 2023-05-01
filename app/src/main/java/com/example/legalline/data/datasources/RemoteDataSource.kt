package com.example.legalline.data.datasources

import com.example.legalline.domain.makeRequest.GptSendData
import com.example.legalline.domain.receiveResponse.GptResponse
import retrofit2.Call
import retrofit2.Callback

interface RemoteDataSource {
    fun getResponse(mesage: GptSendData, apiKey: String): Call<GptResponse>
}