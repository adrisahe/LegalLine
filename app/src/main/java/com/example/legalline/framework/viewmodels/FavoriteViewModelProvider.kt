package com.example.legalline.framework.viewmodels

import androidx.room.Insert
import com.example.legalline.data.repositories.RoomRepository
import com.example.legalline.usecases.DeleteFavorite
import com.example.legalline.usecases.GetAllFavorites
import com.example.legalline.usecases.GetFavoriteById
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class FavoriteViewModelProvider {
    @Provides
    fun getAllFavoritesProvide(repository: RoomRepository) = GetAllFavorites(repository)

    @Provides
    fun deleteFavorite(repository: RoomRepository) = DeleteFavorite(repository)

}