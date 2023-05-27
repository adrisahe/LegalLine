package com.example.legalline.framework.ui.screens.favorites

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.legalline.framework.ui.screens.aplication_app_bar.AplicationTopBar
import com.example.legalline.framework.viewmodels.FavoriteViewModel

@Composable
fun FavoritesScreen(navController: NavHostController, isDarkTheme: MutableState<Boolean>,language: MutableState<java.util.Locale>, vm: FavoriteViewModel = hiltViewModel()) {
    val scaffoldState = rememberScaffoldState()
    Surface(
        modifier = Modifier
            .fillMaxSize()
    ) {

        AplicationTopBar(
            navController,
            scaffoldState,
            isDarkTheme,
            language,
            { FavoriteTopBar(scaffoldState, language) { vm.removeAllFavorites() } }
        ) { ContentFavorites(vm, navController) }

    }
}