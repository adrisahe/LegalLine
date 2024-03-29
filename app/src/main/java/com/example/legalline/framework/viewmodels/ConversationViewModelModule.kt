package com.example.legalline.framework.viewmodels

import androidx.lifecycle.SavedStateHandle
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import javax.inject.Named

@Module
@InstallIn(ViewModelComponent::class)
class ConversationViewModelModule {

    @Provides
    @Named("idNameFavorite")
    fun idNameFavoriteProvider(stateHandle: SavedStateHandle): String{
        return stateHandle.get<String>("idNameFavorite")?: throw IllegalStateException("id name favorites no disponible")
    }
}