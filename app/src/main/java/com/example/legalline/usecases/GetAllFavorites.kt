package com.example.legalline.usecases

import com.example.legalline.data.repositories.RoomRepository

class GetAllFavorites(private val repository: RoomRepository) {
    suspend fun getAllRepository() = repository.getAllConversation()
}