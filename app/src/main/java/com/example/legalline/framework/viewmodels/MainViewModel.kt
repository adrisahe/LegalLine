package com.example.legalline.framework.viewmodels

import android.database.sqlite.SQLiteConstraintException
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

    // value of the send message text
    private val _valueText = MutableStateFlow("")
    val valueText: StateFlow<String> = _valueText.asStateFlow()

    // Respons of the legaline
    private val _responses = MutableStateFlow<List<String>>(emptyList())
    val responses: StateFlow<List<String>> = _responses.asStateFlow()

    // Questions of the users
    private val _questions = MutableStateFlow<List<String>>(emptyList())
    val questions: StateFlow<List<String>> = _questions.asStateFlow()

    // value of the state of the favorite
    private val _favorite = MutableStateFlow(false)
    val favorite: StateFlow<Boolean> = _favorite.asStateFlow()

    // value of the state of the alertDialog
    private val _alertDialog = MutableStateFlow(false)
    val alertDialog: StateFlow<Boolean> = _alertDialog.asStateFlow()

    // value of the state of the dialogText
    private val _dialogText = MutableStateFlow("")
    val dialogText: StateFlow<String> = _dialogText.asStateFlow()

    private val _addError = MutableStateFlow(false)
    val addError: StateFlow<Boolean> = _addError.asStateFlow()


    fun updateText(message: String) {
        _valueText.value = message
    }

    fun updateDialogText(text: String){
        _dialogText.value = text
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
            try {
                addOrDelete.updateDatabase(DbQuestionAndResponse(_dialogText.value, responses.value, questions.value))
                _valueText.value = ""
                _questions.value = emptyList()
                _responses.value = emptyList()
                _dialogText.value = ""
                _favorite.value = !_favorite.value
                _alertDialog.value = !_alertDialog.value
                _addError.value = false
            }catch (duplicated: SQLiteConstraintException){
                _addError.value = true
            }
        }
    }

    fun cancelGestion(){
        _alertDialog.value = !_alertDialog.value
        _dialogText.value = ""
        _addError.value = false
    }

    fun showDialog(){
        _alertDialog.value = !_alertDialog.value
    }
}