package com.example.legalline.framework.ui.screens.main

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.legalline.framework.ui.screens.aplication_app_bar.AplicationTopBar
import com.example.legalline.framework.viewmodels.MainViewModel

/**
 * Pantalla principal de la aplicación
 */
@Composable
fun MainScreen(mainViewModel: MainViewModel, navController: NavHostController) {
    val scaffoldState = rememberScaffoldState()
    Surface(
        modifier = Modifier
            .fillMaxSize()
    ) {
        AplicationTopBar(
            navController, scaffoldState,
            { MainTopBar(scaffoldState) },
            { ContentMainScreen(mainViewModel) }
        )
    }
}