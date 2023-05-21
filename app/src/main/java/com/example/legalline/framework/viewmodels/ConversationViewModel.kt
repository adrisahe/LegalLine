package com.example.legalline.framework.viewmodels

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
class ConversationViewModel @Inject constructor(
    @Named("idNameFavorite") private val idNameFavorite: String,
    repository: DbQuestionAndResponseDao,
    private val sendResponsesAndQuestionRepository: SendResponsesAndQuestionRepository,
    @Named("apiKey") private val apiKey: String,
    private val mensajeAbogado: Message,
    private val dataBase: DbQuestionAndResponseDao
) : ViewModel() {
    private val _nameFavorite = MutableStateFlow("")
    val nameFavorite: StateFlow<String> = _nameFavorite.asStateFlow()

    private val _listQuestions = MutableStateFlow(listOf(""))
    val listQuestions: StateFlow<List<String>> = _listQuestions.asStateFlow()

    private val _listResponses = MutableStateFlow(listOf(""))
    val listResponses: StateFlow<List<String>> = _listResponses.asStateFlow()

    // value of the state of the alertDialog
    private val _alertDialog = MutableStateFlow(false)
    val alertDialog: StateFlow<Boolean> = _alertDialog.asStateFlow()

    // value of the send message text
    private val _valueText = MutableStateFlow("")
    val valueText: StateFlow<String> = _valueText.asStateFlow()

    private val _loading = MutableStateFlow(false)
    val loading: StateFlow<Boolean> = _loading.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            val conversacion = repository.getConversationById(idNameFavorite)
            _nameFavorite.value = conversacion.idNameConversation
            _listQuestions.value = conversacion.questions
            _listResponses.value = conversacion.responses
        }
    }

    fun updateText(message: String) {
        _valueText.value = message
    }

    fun questionAndResponse() {
        viewModelScope.launch(Dispatchers.IO) {
            _loading.value = true
            _listResponses.value =
                _listResponses.value + listOf(sendResponsesAndQuestionRepository.invoke(sendQuestion(), apiKey))
            _loading.value = false
        }
    }

    private fun sendQuestion(): GptSendData {
        _listQuestions.value = _listQuestions.value.plus(_valueText.value)
        val mensaje = Message(_valueText.value, "user")
        val mensaje2 =
            Message(_listResponses.value.getOrNull(_listResponses.value.lastIndex) ?: "", "assistant")
        _valueText.value = ""
        val listaMensajes = listOf(mensajeAbogado, mensaje2, mensaje)
        val cuerpoMensaje = GptSendData(
            listaMensajes, "gpt-3.5-turbo" +
                    "", 0.7
        )
        return cuerpoMensaje
    }

    fun overwritteFavorite(){
        viewModelScope.launch(Dispatchers.IO) {
            dataBase.overWritteConversation(DbQuestionAndResponse(_nameFavorite.value, _listResponses.value, _listQuestions.value))
            _alertDialog.value = !_alertDialog.value
        }
    }

    fun cancelGestion(){
        _alertDialog.value = !_alertDialog.value
    }

    fun showDialog(){
        _alertDialog.value = !_alertDialog.value
    }
}