package com.example.legalline.framework.ui.screens.favorites

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.legalline.framework.ui.screens.aplication_app_bar.AplicationTopBar
import com.example.legalline.framework.viewmodels.FavoriteViewModel

@Composable
fun FavoritesScreen(navController: NavHostController, isDarkTheme: MutableState<Boolean>, vm: FavoriteViewModel = hiltViewModel()) {
    val scaffoldState = rememberScaffoldState()
    Surface(
        modifier = Modifier
            .fillMaxSize()
       // color = Color.Yellow
    ) {
        AplicationTopBar(
            navController,
            scaffoldState,
            isDarkTheme,
            { FavoriteTopBar(scaffoldState) { vm.removeAllFavorites() } }
        ) { ContentFavorites(vm, navController) }

    }
}