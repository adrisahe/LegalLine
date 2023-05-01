package com.example.legalline.framework.ui.screens.favorites

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import com.example.legalline.framework.ui.screens.aplication_app_bar.AplicationTopBar

@Composable
fun FavoritesScreen(navController: NavHostController) {
    val scaffoldState = rememberScaffoldState()
    Surface(
        modifier = Modifier
            .fillMaxSize(),
        color = Color.Yellow
    ) {
        AplicationTopBar(
            navController,
            scaffoldState,
            { FavoriteTopBar(scaffoldState) },
            { Text(text = "prueba")}
        )

    }
}