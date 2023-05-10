package com.example.legalline.framework.ui.screens.conversation

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import com.example.legalline.R

@Composable
fun EditFavoriteButton(){
    IconButton(onClick = { /*TODO*/ }) {
        Icon(painter = painterResource(id = R.drawable.edit_favorite), contentDescription = "edit favorite")
    }
}