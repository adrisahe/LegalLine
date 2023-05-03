package com.example.legalline.data

import com.example.legalline.data.datasources.LocalDataSource
import com.example.legalline.data.datasources.RemoteDataSource
import com.example.legalline.data.repositories.ChatGptRepository
import com.example.legalline.data.repositories.RoomRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class DataModule {
    @Provides
    fun chatGptRepositoryProvider(remoteDataSource: RemoteDataSource) = ChatGptRepository(remoteDataSource)

    @Provides
    fun roomRepositoryProvider(localDataSource: LocalDataSource) = RoomRepository(localDataSource)
}