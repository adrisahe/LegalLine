package com.example.legalline.usecases

import com.example.legalline.data.db.DbQuestionAndResponseDao

class GetAllFavorites(private val repository: DbQuestionAndResponseDao) {
    fun getAllRepository() = repository.getAllConversation()
}