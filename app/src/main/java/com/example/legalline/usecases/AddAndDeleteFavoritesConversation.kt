package com.example.legalline.usecases

import android.util.Log
import com.example.legalline.data.db.DbQuestionAndResponse
import com.example.legalline.data.repositories.RoomRepository

class AddAndDeleteFavoritesConversation(private val repository: RoomRepository) {


    suspend fun updateDatabase(dbQuestionAndResponse: DbQuestionAndResponse){
        repository.insertConversation(dbQuestionAndResponse)
    }

    suspend fun overwritteFavorite(dbQuestionAndResponse: DbQuestionAndResponse){
        repository.insertConversation(dbQuestionAndResponse)
    }

    suspend fun prueba(){
        Log.d("::::", "${repository.getAllConversation()}")
    }
}