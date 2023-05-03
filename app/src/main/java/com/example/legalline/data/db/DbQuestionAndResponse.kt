package com.example.legalline.data.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.legalline.domain.Message

@Entity(tableName = "QUESTIONSANDRESPONSES_table")
data class DbQuestionAndResponse(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id: Int = 0,
    @ColumnInfo(name = "responses") val responses: List<String>,
    @ColumnInfo(name = "questions") val questions: List<String>
)
