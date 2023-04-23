package com.example.legalline.View.MainScreen

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.example.legalline.ViewModel.MainViewModel.MainViewModel

@Composable
fun SendText(mainViewModel: MainViewModel) {
    val valueText by mainViewModel.valueText.collectAsState()
    TextField(
        value = valueText,
        onValueChange = { mainViewModel.updateText(it) },
        shape = CircleShape,
        modifier = Modifier.fillMaxWidth()
    )
}