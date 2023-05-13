package com.example.legalline.framework.ui.screens.main

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.IconToggleButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import com.example.legalline.R
import com.example.legalline.framework.viewmodels.MainViewModel

@Composable
fun FavoriteButton(mainViewModel: MainViewModel) {
    val favorite by mainViewModel.favorite.collectAsState()

    IconButton(onClick = { mainViewModel.showDialog() }) {
        Icon(
            painter = painterResource(id = R.drawable.delete_favorite),
            contentDescription = "favorite icon"
        )
    }
}