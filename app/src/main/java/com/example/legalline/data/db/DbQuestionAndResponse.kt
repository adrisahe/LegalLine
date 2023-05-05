package com.example.legalline.data.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.legalline.domain.Message

@Entity(tableName = "QUESTIONSANDRESPONSES_table")
data class DbQuestionAndResponse(
    @PrimaryKey
    @ColumnInfo(name = "idNameConversation") val idNameConversation: String,
    @ColumnInfo(name = "responses") val responses: List<String>,
    @ColumnInfo(name = "questions") val questions: List<String>
)
