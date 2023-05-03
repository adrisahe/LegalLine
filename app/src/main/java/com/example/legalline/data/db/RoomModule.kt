package com.example.legalline.data.db

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RoomModule {
    private val DATABASE_NAME = "conversation_database"

    @Provides
    fun provideConvertidorDeListaDeCadenasDeTexto(): ConvertidorDeListaDeCadenasDeTexto {
        return ConvertidorDeListaDeCadenasDeTexto()
    }

    @Singleton
    @Provides
    fun provideRoom(@ApplicationContext context: Context, convertidor: ConvertidorDeListaDeCadenasDeTexto) =
        Room.databaseBuilder(context, DbQuestionAndResponseDataBase::class.java, DATABASE_NAME)
            .addTypeConverter(convertidor)
            .build()

    @Singleton
    @Provides
    fun dbQuestionAndResponseDaoProvide(db: DbQuestionAndResponseDataBase) =
        db.dbQuestionAndResponseDao()

}