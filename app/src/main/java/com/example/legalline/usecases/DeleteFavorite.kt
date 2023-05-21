package com.example.legalline.usecases

import com.example.legalline.data.db.DbQuestionAndResponse
import com.example.legalline.data.db.DbQuestionAndResponseDao

class DeleteFavorite(private val repository: DbQuestionAndResponseDao) {
    suspend fun deleteFavorite(dbQuestionAndResponse: DbQuestionAndResponse) =
        repository.deleteConversation(dbQuestionAndResponse)
}