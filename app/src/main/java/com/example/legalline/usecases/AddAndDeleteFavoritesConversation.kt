package com.example.legalline.usecases

import android.util.Log
import com.example.legalline.data.db.DbQuestionAndResponse
import com.example.legalline.data.repositories.RoomRepository

class AddAndDeleteFavoritesConversation(private val repository: RoomRepository) {


    suspend fun updateDatabase(dbQuestionAndResponse: DbQuestionAndResponse){
        if (repository.getAllConversation().contains(dbQuestionAndResponse)){
            repository.deleteConversation(dbQuestionAndResponse)
        }
        else{
            repository.insertConversation(dbQuestionAndResponse)
        }
    }

    suspend fun prueba(){
        Log.d("::::", "${repository.getAllConversation()}")
    }
}