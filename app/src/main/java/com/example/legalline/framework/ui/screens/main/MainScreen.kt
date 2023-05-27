package com.example.legalline.framework.ui.screens.main

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.legalline.framework.ui.screens.aplication_app_bar.AplicationTopBar
import com.example.legalline.framework.viewmodels.MainViewModel

/**
 * Pantalla principal de la aplicación
 */
@Composable
fun MainScreen(
    navController: NavHostController,
    isDarkTheme: MutableState<Boolean>,
    language: MutableState<java.util.Locale>,
    mainViewModel: MainViewModel = hiltViewModel()
) {
    mainViewModel.setLanguage(language.value.language)
    val scaffoldState = rememberScaffoldState()
    Surface(
        modifier = Modifier
            .fillMaxSize()
    ) {
        AplicationTopBar(
            navController, scaffoldState, isDarkTheme, language,
            { MainTopBar(scaffoldState, mainViewModel) }
        ) { ContentMainScreen(mainViewModel, language) }
    }
}