package com.example.legalline.framework.viewmodels

import androidx.lifecycle.SavedStateHandle
import com.example.legalline.data.db.DbQuestionAndResponse
import com.example.legalline.data.repositories.RoomRepository
import com.example.legalline.usecases.GetFavoriteById
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

  // @Provides
  // suspend fun getConversationByIdProvider(@Named("idNameFavorite") idNameFavorite: String, repository: RoomRepository): DbQuestionAndResponse{
  //     return repository.getConversationById(idNameFavorite)
  // }
}