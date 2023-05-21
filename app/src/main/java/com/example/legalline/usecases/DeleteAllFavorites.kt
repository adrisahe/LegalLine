package com.example.legalline.usecases

import com.example.legalline.data.db.DbQuestionAndResponseDao

class DeleteAllFavorites(private val repository: DbQuestionAndResponseDao) {
    suspend fun deleteAllFavorites() = repository.deleteConversations()
}