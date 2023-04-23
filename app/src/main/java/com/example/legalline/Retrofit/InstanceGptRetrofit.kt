package com.example.legalline.Retrofit

import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object InstanceGptRetrofit {
    private fun getGptService(): Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://api.openai.com/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    val chatGptApi = getGptService().create(ChatGptApi::class.java)
}