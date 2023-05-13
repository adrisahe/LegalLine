package com.example.legalline.framework.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.legalline.data.db.DbQuestionAndResponse
import com.example.legalline.usecases.DeleteAllFavorites
import com.example.legalline.usecases.DeleteFavorite
import com.example.legalline.usecases.GetAllFavorites
import com.example.legalline.usecases.GetFavoriteById
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel @Inject constructor(
    private val getAllFavorites: GetAllFavorites,
    private val deleteFavorite: DeleteFavorite,
    private val deleteAllFavorites: DeleteAllFavorites
) : ViewModel() {
    private val _favorites = MutableStateFlow<List<DbQuestionAndResponse>>(emptyList())
    val favorites: StateFlow<List<DbQuestionAndResponse>> = _favorites.asStateFlow()

    init {
        viewModelScope.launch {
            _favorites.value = getAllFavorites.getAllRepository()
        }
    }

    fun removeFavorite(idNameFavorites: String, responses: List<String>, questions: List<String>) {
        viewModelScope.launch {
            deleteFavorite.deleteFavorite(
                DbQuestionAndResponse(
                    idNameFavorites,
                    responses,
                    questions
                )
            )
            _favorites.value = getAllFavorites.getAllRepository()
        }
    }
    fun removeAllFavorites(){
        viewModelScope.launch {
            Log.d("::::", "adios")
            deleteAllFavorites.deleteAllFavorites()
            Log.d("::::", "hola")
            _favorites.value = getAllFavorites.getAllRepository()
        }
    }
}