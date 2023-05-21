package com.example.legalline.framework.viewmodels

import com.example.legalline.data.db.DbQuestionAndResponseDao
import com.example.legalline.usecases.DeleteAllFavorites
import com.example.legalline.usecases.DeleteFavorite
import com.example.legalline.usecases.GetAllFavorites
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class FavoriteViewModelProvider {
    @Provides
    fun getAllFavoritesProvide(repository: DbQuestionAndResponseDao) = GetAllFavorites(repository)

    @Provides
    fun deleteFavorite(repository: DbQuestionAndResponseDao) = DeleteFavorite(repository)

    @Provides
    fun deleteAllFavorites(repository: DbQuestionAndResponseDao) = DeleteAllFavorites(repository)

}