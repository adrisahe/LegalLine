package com.example.legalline.usecases

import com.example.legalline.data.db.DbQuestionAndResponse
import com.example.legalline.data.db.DbQuestionAndResponseDao

class AddAndDeleteFavoritesConversation(private val repository: DbQuestionAndResponseDao) {


    suspend fun updateDatabase(dbQuestionAndResponse: DbQuestionAndResponse){
        repository.insertConversation(dbQuestionAndResponse)
    }

    suspend fun overwritteFavorite(dbQuestionAndResponse: DbQuestionAndResponse){
        repository.overWritteConversation(dbQuestionAndResponse)
    }
}