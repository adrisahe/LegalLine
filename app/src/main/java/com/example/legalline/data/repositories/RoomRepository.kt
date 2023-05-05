package com.example.legalline.data.repositories

import com.example.legalline.data.datasources.LocalDataSource
import com.example.legalline.data.datasources.RemoteDataSource
import com.example.legalline.data.db.DbQuestionAndResponse

class RoomRepository(private val localDataSource: LocalDataSource) {
    suspend fun getAllConversation() = localDataSource.getAllConversation()

    //suspend fun getConversationById(id: Int) = localDataSource.getConversationById(id)

    suspend fun insertConversation(dbQuestionAndResponse: DbQuestionAndResponse) =
        localDataSource.insertConversation(dbQuestionAndResponse)

    suspend fun deleteConversation(dbQuestionAndResponse: DbQuestionAndResponse) =
        localDataSource.deleteConversation(dbQuestionAndResponse)

    suspend fun deleteConversations() = localDataSource.deleteConversations()
}