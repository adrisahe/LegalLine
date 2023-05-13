package com.example.legalline.usecases

import com.example.legalline.data.repositories.RoomRepository

class DeleteAllFavorites(private val repository: RoomRepository) {
    suspend fun deleteAllFavorites() = repository.deleteConversations()
}