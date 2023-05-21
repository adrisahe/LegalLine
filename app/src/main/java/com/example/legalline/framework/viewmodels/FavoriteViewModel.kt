package com.example.legalline.framework.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.legalline.data.db.DbQuestionAndResponse
import com.example.legalline.data.db.DbQuestionAndResponseDao
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel @Inject constructor(
    private val dataBase: DbQuestionAndResponseDao
) : ViewModel() {
    private val _favorites = MutableStateFlow<List<DbQuestionAndResponse>>(emptyList())
    val favorites: StateFlow<List<DbQuestionAndResponse>> = _favorites.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            dataBase.getAllConversation().collect{
                _favorites.value = it
            }
        }
    }

    fun removeFavorite(idNameFavorites: String, responses: List<String>, questions: List<String>) {
        viewModelScope.launch(Dispatchers.IO) {
            dataBase.deleteConversation(
                DbQuestionAndResponse(
                    idNameFavorites,
                    responses,
                    questions
                )
            )
            dataBase.getAllConversation().collect{
                _favorites.value = it
            }
        }
    }
    fun removeAllFavorites(){
        viewModelScope.launch(Dispatchers.IO) {
            dataBase.deleteConversations()
            dataBase.getAllConversation().collect{
                _favorites.value = it
            }
        }
    }
}