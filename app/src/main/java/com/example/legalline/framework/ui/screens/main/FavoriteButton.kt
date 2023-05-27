package com.example.legalline.framework.ui.screens.main

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.ScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.example.legalline.R
import com.example.legalline.framework.viewmodels.MainViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun FavoriteButton(
    mainViewModel: MainViewModel
) {
    IconButton(onClick = {
        mainViewModel.showDialog()
    }) {
        Icon(
            painter = painterResource(id = R.drawable.delete_favorite),
            contentDescription = stringResource(id = R.string.iconFavoriteDescription)
        )
    }
}