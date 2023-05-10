package com.example.legalline.framework.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.legalline.data.db.DbQuestionAndResponse
import com.example.legalline.data.repositories.RoomRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Named

@HiltViewModel
class ConversationViewModel @Inject constructor(@Named("idNameFavorite") private val idNameFavorite: String, repository: RoomRepository): ViewModel() {
    private val _nameFavorite = MutableStateFlow("")
    val nameFavorite: StateFlow<String> = _nameFavorite

    private val _listQuestions = MutableStateFlow(listOf(""))
    val listQuestions: StateFlow<List<String>> = _listQuestions

    private val _listResponses = MutableStateFlow(listOf(""))
    val listResponses: StateFlow<List<String>> = _listResponses

    init {
        viewModelScope.launch {
            val conversacion = repository.getConversationById(idNameFavorite)
            _nameFavorite.value = conversacion.idNameConversation
            _listQuestions.value = conversacion.questions
            _listResponses.value = conversacion.responses
        }
    }
}