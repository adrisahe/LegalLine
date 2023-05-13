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
class MainViewModelModule {
    @Provides
    fun SendResponsesAndQuestionProvider(chatGptRepository: ChatGptRepository) =
        SendResponsesAndQuestion(chatGptRepository)

    @Provides
    fun sendQuestion(): Message {
        return Message(
            "Eres un letrado español altamente especializado en derecho que solo responde preguntas relacionadas " +
                    "con temas legales, tienes un profundo conocimiento en diversas areas del derecho, como lo civil, penal, laboral y administrativo. " +
                    "pueden hacerte cualquier pregunta legal y le proporcionaras una respuesta detallada y precisa, pero no responderas preguntas " +
                    "que no estén directamente relacionadas con el ámbito legal.", "system"
        )
    }

    @Provides
    fun addAndDeleteFavoritesConversation(roomRepository: RoomRepository) =
        AddAndDeleteFavoritesConversation(roomRepository)
}