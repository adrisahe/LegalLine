package com.example.legalline.framework.data.datasources

import com.example.legalline.data.datasources.LocalDataSource
import com.example.legalline.data.db.DbQuestionAndResponse
import com.example.legalline.data.db.DbQuestionAndResponseDao

class RoomDatabaseGestion(private val dbQuestionAndResponseDao: DbQuestionAndResponseDao): LocalDataSource {
    override suspend fun getAllConversation(): List<DbQuestionAndResponse> {
        return dbQuestionAndResponseDao.getAllConversation()
    }

    override suspend fun getConversationById(idNameFavorite: String): DbQuestionAndResponse {
        return dbQuestionAndResponseDao.getConversationById(idNameFavorite)
    }

    override suspend fun insertConversation(dbQuestionAndResponse: DbQuestionAndResponse) {
        return dbQuestionAndResponseDao.insertConversation(dbQuestionAndResponse)
    }

    override suspend fun deleteConversation(dbQuestionAndResponse: DbQuestionAndResponse) {
        return dbQuestionAndResponseDao.deleteConversation(dbQuestionAndResponse)
    }

    override suspend fun deleteConversations() {
        return dbQuestionAndResponseDao.deleteConversations()
    }
}