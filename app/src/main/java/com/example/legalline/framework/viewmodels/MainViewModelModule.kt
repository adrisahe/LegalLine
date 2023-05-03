package com.example.legalline.framework.viewmodels

import com.example.legalline.data.repositories.ChatGptRepository
import com.example.legalline.data.repositories.RoomRepository
import com.example.legalline.domain.Message
import com.example.legalline.usecases.AddAndDeleteFavoritesConversation
import com.example.legalline.usecases.SendResponsesAndQuestion
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import javax.inject.Singleton

@Module
@InstallIn(ViewModelComponent::class)
class MainViewModelModule{
    @Provides
    fun SendResponsesAndQuestionProvider(chatGptRepository: ChatGptRepository) = SendResponsesAndQuestion(chatGptRepository)

    @Provides
    fun sendQuestion(): Message{
        return Message("Eres un abogado experto en derecho y temas legales, si te hago una pregunta relacionada con \" +\n" +
                "\"el tema de derecho y los temas legales me responderas con la verdad, en caso contrario responderas que eres un \" +\n" +
                "\"abogado y que no tienes conocimientos sobre ese tema.", "system")
    }

    @Provides
    fun addAndDeleteFavoritesConversation(roomRepository: RoomRepository) = AddAndDeleteFavoritesConversation(roomRepository)
}