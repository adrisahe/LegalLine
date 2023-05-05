package com.example.legalline.framework.viewmodels

import android.util.Log
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.legalline.data.db.DbQuestionAndResponse
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
class MainViewModel @Inject constructor(
    private val sendResponsesAndQuestion: SendResponsesAndQuestion,
    @Named("apiKey") private val apiKey: String,
    private val mensajeAbogado: Message,
    private val addOrDelete: AddAndDeleteFavoritesConversation
) : ViewModel() {

    private val _valueText = MutableStateFlow("")
    val valueText: StateFlow<String> = _valueText.asStateFlow()

    private val _responses = MutableStateFlow<List<String>>(emptyList())
    val responses: StateFlow<List<String>> = _responses.asStateFlow()

    private val _questions = MutableStateFlow<List<String>>(emptyList())
    val questions: StateFlow<List<String>> = _questions.asStateFlow()

    private val _favorite = MutableStateFlow(false)
    val favorite: StateFlow<Boolean> = _favorite.asStateFlow()

    private val _alertDialog = MutableStateFlow(false)
    val alertDialog: StateFlow<Boolean> = _alertDialog.asStateFlow()


    fun updateText(message: String) {
        _valueText.value = message
    }

    fun questionAndResponse() {
        viewModelScope.launch {
            _responses.value =
                _responses.value + listOf(sendResponsesAndQuestion.invoke(sendQuestion(), apiKey))
        }
    }

    private fun sendQuestion(): GptSendData {
        _questions.value = _questions.value.plus(_valueText.value)
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

            addOrDelete.updateDatabase(DbQuestionAndResponse("hola", responses.value, questions.value))
            addOrDelete.prueba()
            _favorite.value = !_favorite.value
        }
    }

    fun showDialog(){
        _alertDialog.value = !_alertDialog.value
    }
}