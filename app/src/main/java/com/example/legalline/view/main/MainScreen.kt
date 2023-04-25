package com.example.legalline.view.main

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import com.example.legalline.viewModels.MainViewModel

/**
 * Pantalla principal de la aplicación
 */
@Composable
fun MainScreen(mainViewModel: MainViewModel, navController: NavHostController) {
    Surface(
        modifier = Modifier
            .fillMaxSize(),
        color = Color.Yellow


    ) {
        TopBar(mainViewModel, navController)
    }
}