package com.example.legalline.viewModels

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.legalline.Model.Message
import com.example.legalline.Model.makeRequest.GptSendData
import com.example.legalline.Model.receiveResponse.GptResponse
import com.example.legalline.Retrofit.InstanceGptRetrofit
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel(private val apiKey: String) : ViewModel() {
    private val _valueText = MutableStateFlow("")
    val valueText: StateFlow<String> = _valueText.asStateFlow()

    private val _responses = MutableStateFlow<List<String>>(emptyList())
    val responses: StateFlow<List<String>> = _responses.asStateFlow()

    private val _questions = MutableStateFlow<List<String>>(emptyList())
    val questions: StateFlow<List<String>> = _questions.asStateFlow()

    fun updateText(message: String) {
        _valueText.value = message
    }



    fun questionAndResponse() {
        val mensajeAbogado = Message(
            "Eres un abogado experto en derecho y temas legales, si te hago una pregunta relacionada con \" +\n" +
                "\"el tema de derecho y los temas legales me responderas con la verdad, en caso contrario responderas que eres un \" +\n" +
                "\"abogado y que no tienes conocimientos sobre ese tema.", "system"
        )
        //val messages = listOf(mensaje)
        _questions.value = _questions.value.plus(_valueText.value)
        val mensaje = Message(_valueText.value, "user")
        _valueText.value = ""
        val listaMensajes = listOf(mensajeAbogado, mensaje)
        val cuerpoMensaje = GptSendData(
            listaMensajes, "gpt-3.5-turbo" +
                    "", 0.7
        )
        try {
            val call = InstanceGptRetrofit.chatGptApi.sendQuestion(
                cuerpoMensaje,
                apiKey,
            )
            call.enqueue(object : Callback<GptResponse> {
                override fun onResponse(call: Call<GptResponse>, response: Response<GptResponse>) {
                    if (response.isSuccessful) {
                        val chatResponse: String? =
                            response.body()?.choices?.get(0)?.message?.content
                        _responses.value =
                            _responses.value + listOf(chatResponse ?: "Respuesta no disponible")
                    } else {
                        Log.d("::::", "${response.errorBody()}")
                    }
                }

                override fun onFailure(call: Call<GptResponse>, t: Throwable) {
                    Log.d("::::", "Error al enviar la solicitud a la API: ${t.message}")
                }
            })
        } catch (e: Exception) {
            Log.d("::::", "Error al enviar la solicitud a la API: ${e.message}")
        }

    }
}