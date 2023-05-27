package com.example.legalline.data.repositories

import android.util.Log
import com.example.legalline.R
import com.example.legalline.domain.makeRequest.GptSendData
import com.example.legalline.domain.receiveResponse.GptResponse
import com.example.legalline.data.network.ChatGptApi
import com.google.mlkit.nl.languageid.LanguageIdentification
import com.google.mlkit.nl.languageid.LanguageIdentifier
import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.concurrent.TimeUnit

class SendResponsesAndQuestionRepository (
    private val repository: ChatGptApi
) {
    suspend fun invoke(message: GptSendData, apiKey: String): String = withContext(Dispatchers.IO){
        val chatResponse = CompletableDeferred<String>()
        repository.sendQuestion(message, apiKey).enqueue(object : Callback<GptResponse>{
            override fun onResponse(call: Call<GptResponse>, response: Response<GptResponse>) {
                if(response.isSuccessful){
                    chatResponse.complete(response.body()?.choices?.get(0)?.message?.content ?: "nulo")
                }
                else{
                    chatResponse.complete("Error")
                }
            }

            override fun onFailure(call: Call<GptResponse>, t: Throwable) {
                chatResponse.complete("Error")
                Log.d("::::", t.message.toString())
            }

        })
        chatResponse.await()
    }
}