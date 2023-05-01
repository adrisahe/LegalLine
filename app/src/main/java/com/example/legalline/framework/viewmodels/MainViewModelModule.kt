package com.example.legalline.framework.viewmodels

import com.example.legalline.data.repositories.ChatGptRepository
import com.example.legalline.usecases.SendResponsesAndQuestion
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class MainViewModelModule{
    @Provides
    fun SendResponsesAndQuestionProvider(chatGptRepository: ChatGptRepository) = SendResponsesAndQuestion(chatGptRepository)
}