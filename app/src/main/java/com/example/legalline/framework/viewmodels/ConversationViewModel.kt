package com.example.legalline.framework.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.legalline.data.db.DbQuestionAndResponse
import com.example.legalline.data.repositories.RoomRepository
import com.example.legalline.domain.Message
import com.example.legalline.domain.makeRequest.GptSendData
import com.example.legalline.usecases.AddAndDeleteFavoritesConversation
import com.example.legalline.usecases.SendResponsesAndQuestion
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Named

@HiltViewModel
class ConversationViewModel @Inject constructor(
    @Named("idNameFavorite") private val idNameFavorite: String,
    repository: RoomRepository,
    private val sendResponsesAndQuestion: SendResponsesAndQuestion,
    @Named("apiKey") private val apiKey: String,
    private val mensajeAbogado: Message,
    private val addOrDelete: AddAndDeleteFavoritesConversation
) : ViewModel() {
    private val _nameFavorite = MutableStateFlow("")
    val nameFavorite: StateFlow<String> = _nameFavorite

    private val _listQuestions = MutableStateFlow(listOf(""))
    val listQuestions: StateFlow<List<String>> = _listQuestions

    private val _listResponses = MutableStateFlow(listOf(""))
    val listResponses: StateFlow<List<String>> = _listResponses

    // value of the state of the favorite
    private val _favorite = MutableStateFlow(false)
    val favorite: StateFlow<Boolean> = _favorite.asStateFlow()

    // value of the state of the alertDialog
    private val _alertDialog = MutableStateFlow(false)
    val alertDialog: StateFlow<Boolean> = _alertDialog.asStateFlow()

    // value of the state of the dialogText
    private val _dialogText = MutableStateFlow("")
    val dialogText: StateFlow<String> = _dialogText

    // value of the send message text
    private val _valueText = MutableStateFlow("")
    val valueText: StateFlow<String> = _valueText.asStateFlow()

    init {
        viewModelScope.launch {
            val conversacion = repository.getConversationById(idNameFavorite)
            _nameFavorite.value = conversacion.idNameConversation
            _listQuestions.value = conversacion.questions
            _listResponses.value = conversacion.responses
        }
    }

    fun updateText(message: String) {
        _valueText.value = message
    }

    fun updateDialogText(text: String){
        _dialogText.value = text
    }

    fun questionAndResponse() {
        viewModelScope.launch {
            _listResponses.value =
                _listResponses.value + listOf(sendResponsesAndQuestion.invoke(sendQuestion(), apiKey))
        }
    }

    private fun sendQuestion(): GptSendData {
        _listQuestions.value = _listQuestions.value.plus(_valueText.value)
        val mensaje = Message(_valueText.value, "user")
        _valueText.value = ""
        val listaMensajes = listOf(mensajeAbogado, mensaje)
        val cuerpoMensaje = GptSendData(
            listaMensajes, "gpt-3.5-turbo" +
                    "", 0.7
        )
        return cuerpoMensaje
    }

    fun favoritesGestion(){
        viewModelScope.launch {
            addOrDelete.updateDatabase(DbQuestionAndResponse(_dialogText.value, _listResponses.value, _listQuestions.value))
            addOrDelete.prueba()
            _favorite.value = !_favorite.value
            _alertDialog.value = !_alertDialog.value
        }
    }

    fun overwritteFavorite(){
        viewModelScope.launch {
            addOrDelete.overwritteFavorite(DbQuestionAndResponse(_nameFavorite.value, _listResponses.value, _listQuestions.value))
            _alertDialog.value = !_alertDialog.value
        }
    }

    fun cancelGestion(){
        _alertDialog.value = !_alertDialog.value
        _dialogText.value = ""
    }

    fun showDialog(){
        _alertDialog.value = !_alertDialog.value
    }
}