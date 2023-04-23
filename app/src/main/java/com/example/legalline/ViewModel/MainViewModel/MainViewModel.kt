package com.example.legalline.ViewModel.MainViewModel

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

    private val _conversation = MutableStateFlow<List<String>>(emptyList())
    val conversation: StateFlow<List<String>> = _conversation.asStateFlow()

    fun updateText(message: String) {
        _valueText.value = message
    }

    fun questionAndResponse(){
        /*val mensaje = Message(
            "Eres un abogado experto en derecho y temas legales, si te hago una pregunta relacionada con \" +\n" +
                "\"el tema de derecho o temas legales me responderas con la verdad, en caso contrario responderas que eres un \" +\n" +
                "\"abogado y que no tienes conocimientos sobre ese tema.", "system"
        )
        val messages = listOf(mensaje)*/
        val mensaje = Message(_valueText.value, "user")
        val listaMensajes = listOf(mensaje)
        val cuerpoMensaje = GptSendData(listaMensajes, "gpt-3.5-turbo" +
                "", 0.7)
        try {
            val call = InstanceGptRetrofit.chatGptApi.sendQuestion(
                cuerpoMensaje,
                apiKey,
            )
            call.enqueue(object : Callback<GptResponse> {
                override fun onResponse(call: Call<GptResponse>, response: Response<GptResponse>) {
                    if (response.isSuccessful) {
                        val chatResponse: String? = response.body()?.choices?.get(0)?.message?.content
                        Log.d(":::", response.body()?.choices?.get(0)?.message?.content ?: "nulo")
                        _conversation.value = _conversation.value + listOf(_valueText.value, chatResponse?: "Respuesta no disponible")
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

    init {

        //viewModelScope.launch {
            /*val mensaje = Message("donde ver las auroras boreales", "user")
            val listaMensajes = listOf(mensaje)
            val cuerpoMensaje = GptSendData(listaMensajes, "gpt-3.5-turbo" +
                    "", 0.7)
            try {
                val call = InstanceGptRetrofit.chatGptApi.sendQuestion(
                    cuerpoMensaje,
                    apiKey,
                )
                call.enqueue(object : Callback<GptResponse> {
                    override fun onResponse(call: Call<GptResponse>, response: Response<GptResponse>) {
                        if (response.isSuccessful) {
                            Log.d(":::", response.body()?.choices?.get(0)?.message?.content ?: "nulo")
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
            }*/
       // }
    }
}