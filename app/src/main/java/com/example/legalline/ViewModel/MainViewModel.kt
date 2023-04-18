package com.example.legalline.ViewModel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class MainViewModel: ViewModel() {
    private val _valueText = MutableStateFlow("")
    val valueText: StateFlow<String> = _valueText

    fun updateText(message: String){
        _valueText.value = message
    }
}