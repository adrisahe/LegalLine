package com.example.legalline.framework.ui.screens.favorites

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import com.example.legalline.R

@Composable
fun DeleteAllButton(removeAllFavorites: () -> Unit) {
    IconButton(onClick = {
        removeAllFavorites()
    }) {
        Icon(painter = painterResource(id = R.drawable.delete_all), contentDescription = "delete all favorites")
    }
}