package com.example.legalline.View.MainScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.legalline.ViewModel.MainViewModel

@Composable
fun SendText(mainViewModel: MainViewModel) {
    val valueText by mainViewModel.valueText.collectAsState()
    TextField(
        value = valueText,
        onValueChange = { mainViewModel.updateText(it) },
        modifier = Modifier
            .fillMaxWidth()
    )
}