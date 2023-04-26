package com.example.legalline.view.main

import androidx.compose.material.Icon
import androidx.compose.material.IconToggleButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import com.example.legalline.R

@Composable
fun FavoriteButton(){
    IconToggleButton(checked = true, onCheckedChange = {true}) {
        Icon(
            painter = painterResource(id = R.drawable.delete_favorite),
            contentDescription = "favorite icon"
        )
    }
}