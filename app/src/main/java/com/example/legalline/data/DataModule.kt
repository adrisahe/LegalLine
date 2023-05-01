package com.example.legalline.data

import com.example.legalline.data.datasources.RemoteDataSource
import com.example.legalline.data.repositories.ChatGptRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class DataModule {
    @Provides
    fun chatGptRepositoryProvider(remoteDataSource: RemoteDataSource) = ChatGptRepository(remoteDataSource)
}