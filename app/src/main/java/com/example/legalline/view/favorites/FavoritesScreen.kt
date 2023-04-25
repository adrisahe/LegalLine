package com.example.legalline.view.favorites

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun FavoritesScreen(){
    Surface(
        modifier = Modifier
            .fillMaxSize(),
        color = Color.Yellow
    ) {
        Text(text = "prueba")
    }
}