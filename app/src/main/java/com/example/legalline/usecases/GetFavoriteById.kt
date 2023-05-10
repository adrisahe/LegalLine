package com.example.legalline.usecases

import com.example.legalline.data.repositories.RoomRepository

class GetFavoriteById(private val repository: RoomRepository) {
    suspend fun getFavoriteById(idNameFavorite: String) = repository.getConversationById(idNameFavorite)
}