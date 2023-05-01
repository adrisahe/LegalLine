package com.example.legalline.usecases

import com.example.legalline.data.repositories.ChatGptRepository
import com.example.legalline.domain.makeRequest.GptSendData
import com.example.legalline.domain.receiveResponse.GptResponse
import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SendResponsesAndQuestion (private val repository: ChatGptRepository) {
    suspend fun invoke(message: GptSendData, apiKey: String): String = withContext(Dispatchers.IO){
        val chatResponse = CompletableDeferred<String>()
        repository.getResponses(message, apiKey).enqueue(object : Callback<GptResponse>{
            override fun onResponse(call: Call<GptResponse>, response: Response<GptResponse>) {
                if(response.isSuccessful){
                    chatResponse.complete(response.body()?.choices?.get(0)?.message?.content ?: "nulo")
                }
                else{
                    chatResponse.complete("esa pregunta no merece respuesta")
                }
            }

            override fun onFailure(call: Call<GptResponse>, t: Throwable) {
                chatResponse.complete("No hay conexion a internet")
            }

        })
        chatResponse.await()
    }
}