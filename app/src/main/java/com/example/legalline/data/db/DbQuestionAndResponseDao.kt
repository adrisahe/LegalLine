package com.example.legalline.data.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface DbQuestionAndResponseDao {
    @Query("SELECT * FROM QUESTIONSANDRESPONSES_table")
    suspend fun getAllConversation(): List<DbQuestionAndResponse>

    @Query("SELECT * FROM QUESTIONSANDRESPONSES_table WHERE id = :id")
    suspend fun getConversationById(id: Int): DbQuestionAndResponse

    @Insert
    suspend fun insertConversation(dbQuestionAndResponse: DbQuestionAndResponse)

    @Delete
    suspend fun deleteConversation(dbQuestionAndResponse: DbQuestionAndResponse)
}