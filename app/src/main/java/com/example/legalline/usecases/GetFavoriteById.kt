package com.example.legalline.usecases

import com.example.legalline.data.db.DbQuestionAndResponseDao

class GetFavoriteById(private val repository: DbQuestionAndResponseDao) {
    suspend fun getFavoriteById(idNameFavorite: String) = repository.getConversationById(idNameFavorite)
}