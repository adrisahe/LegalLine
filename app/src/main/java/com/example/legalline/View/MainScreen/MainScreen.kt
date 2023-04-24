package com.example.legalline.View

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.legalline.View.MainScreen.TopBar
import com.example.legalline.ViewModel.MainViewModel.MainViewModel

/**
 * Pantalla principal de la aplicación
 */
@Composable
fun MainScreen(mainViewModel: MainViewModel) {
    Surface(
        modifier = Modifier
            .fillMaxSize(),
        color = Color.Yellow
    ) {
        TopBar(mainViewModel)
    }
}