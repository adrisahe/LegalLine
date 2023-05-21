package com.example.legalline.framework.viewmodels

import android.database.sqlite.SQLiteConstraintException
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.legalline.data.db.DbQuestionAndResponse
import com.example.legalline.data.db.DbQuestionAndResponseDao
import com.example.legalline.domain.Message
import com.example.legalline.domain.makeRequest.GptSendData
import com.example.legalline.data.repositories.SendResponsesAndQuestionRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Named


@HiltViewModel
class MainViewModel @Inject constructor(
    private val sendResponsesAndQuestionRepository: SendResponsesAndQuestionRepository,
    @Named("apiKey") private val apiKey: String,
    private val mensajeAbogado: Message,
    private val dataBase: DbQuestionAndResponseDao
) : ViewModel() {

    // valor del textField que envia el usuario
    private val _valueText = MutableStateFlow("")
    val valueText: StateFlow<String> = _valueText.asStateFlow()

    // Respuestas de legaline
    private val _responses = MutableStateFlow<List<String>>(emptyList())
    val responses: StateFlow<List<String>> = _responses.asStateFlow()

    // Preguntas del usuario
    private val _questions = MutableStateFlow<List<String>>(emptyList())
    val questions: StateFlow<List<String>> = _questions.asStateFlow()

    // valor que controla cuando se muestra el alertDialog para guardar el favorito
    private val _alertDialog = MutableStateFlow(false)
    val alertDialog: StateFlow<Boolean> = _alertDialog.asStateFlow()

    // valor del textField del alertDialog
    private val _dialogText = MutableStateFlow("")
    val dialogText: StateFlow<String> = _dialogText.asStateFlow()

    // valor que indica si se ha introducido un valor erroneo en alertDialog
    private val _addError = MutableStateFlow(false)
    val addError: StateFlow<Boolean> = _addError.asStateFlow()

    // valor que indica si legaline esta pensando
    private val _loading = MutableStateFlow(false)
    val loading: StateFlow<Boolean> = _loading.asStateFlow()


    fun updateText(message: String) {
        _valueText.value = message
    }

    fun updateDialogText(text: String) {
        if (text.length <= 30) {
            _dialogText.value = text
        }
    }

    fun questionAndResponse() {
        viewModelScope.launch(Dispatchers.IO) {
            _loading.value = true
            _responses.value = _responses.value + listOf(sendResponsesAndQuestionRepository.invoke(sendQuestion(), apiKey))
            _loading.value = false
        }
    }

    private fun sendQuestion(): GptSendData {
        _questions.value = _questions.value.plus(_valueText.value)
        val mensaje = Message(_valueText.value, "user")
        val mensaje2 =
            Message(_responses.value.getOrNull(_responses.value.lastIndex) ?: "", "assistant")
        _valueText.value = ""
        val listaMensajes = listOf(mensajeAbogado, mensaje2, mensaje)
        val cuerpoMensaje = GptSendData(
            listaMensajes, "gpt-3.5-turbo" +
                    "", 0.7
        )
        return cuerpoMensaje
    }

    fun favoritesGestion() {
        viewModelScope.launch(Dispatchers.IO) {
            if (_dialogText.value.length < 5) {
                _addError.value = true
            } else {
                try {
                    dataBase.insertConversation(
                        DbQuestionAndResponse(
                            _dialogText.value,
                            responses.value,
                            questions.value
                        )
                    )
                    _valueText.value = ""
                    _questions.value = emptyList()
                    _responses.value = emptyList()
                    _dialogText.value = ""
                    _alertDialog.value = !_alertDialog.value
                    _addError.value = false
                } catch (duplicated: SQLiteConstraintException) {
                    _addError.value = true
                }
            }
        }
    }

    fun cancelGestion() {
        _alertDialog.value = !_alertDialog.value
        _dialogText.value = ""
        _addError.value = false
    }

    fun showDialog() {
        _alertDialog.value = !_alertDialog.value
    }
}