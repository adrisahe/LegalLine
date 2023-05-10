package com.example.legalline.usecases

import com.example.legalline.data.db.DbQuestionAndResponse
import com.example.legalline.data.repositories.RoomRepository

class DeleteFavorite(private val repository: RoomRepository) {
    suspend fun deleteFavorite(dbQuestionAndResponse: DbQuestionAndResponse) =
        repository.deleteConversation(dbQuestionAndResponse)
}