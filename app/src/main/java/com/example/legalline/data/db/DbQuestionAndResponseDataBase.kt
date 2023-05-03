package com.example.legalline.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(
    entities = [DbQuestionAndResponse::class],
    exportSchema = false,
    version = 1,
)
@TypeConverters(ConvertidorDeListaDeCadenasDeTexto::class)
abstract class DbQuestionAndResponseDataBase: RoomDatabase() {
    abstract fun dbQuestionAndResponseDao(): DbQuestionAndResponseDao
}