package com.example.legalline.framework

import android.content.Context
import com.example.legalline.R
import com.example.legalline.data.network.ChatGptApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class FrameworkModule {
    @Provides
    @Singleton
    fun retrofitProvider(): Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://api.openai.com/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    @Provides
    @Singleton
    fun chatGptServiceProvider(retrofit: Retrofit): ChatGptApi = retrofit.create(ChatGptApi::class.java)

    @Provides
    @Singleton
    @Named("apiKey")
    fun apiKeyProvider(@ApplicationContext context: Context): String{
        return context.getString(R.string.apy_key)
    }

}