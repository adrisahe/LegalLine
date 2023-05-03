package com.example.legalline.data.datasources

import androidx.room.Delete
import androidx.room.Update
import com.example.legalline.data.db.DbQuestionAndResponse
import com.example.legalline.data.db.DbQuestionAndResponseDao
import com.example.legalline.domain.makeRequest.GptSendData
import com.example.legalline.domain.receiveResponse.GptResponse
import retrofit2.Call

interface LocalDataSource {
    suspend fun getAllConversation(): List<DbQuestionAndResponse>

    //suspend fun getConversationById(id: Int): DbQuestionAndResponse

    suspend fun insertConversation(dbQuestionAndResponse: DbQuestionAndResponse)

    suspend fun deleteConversation(dbQuestionAndResponse: DbQuestionAndResponse)
}