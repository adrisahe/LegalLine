package com.example.legalline.data.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface DbQuestionAndResponseDao {
    @Query("SELECT * FROM QUESTIONSANDRESPONSES_table")
    fun getAllConversation(): Flow<List<DbQuestionAndResponse>>

    @Query("SELECT * FROM QUESTIONSANDRESPONSES_table WHERE idNameConversation = :idNameConversation")
    suspend fun getConversationById(idNameConversation: String): DbQuestionAndResponse

    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun insertConversation(dbQuestionAndResponse: DbQuestionAndResponse)

    @Delete
    suspend fun deleteConversation(dbQuestionAndResponse: DbQuestionAndResponse)

    @Query("DELETE FROM QUESTIONSANDRESPONSES_table")
    suspend fun deleteConversations()

    @Update
    suspend fun overWritteConversation(bQuestionAndResponse: DbQuestionAndResponse)
}