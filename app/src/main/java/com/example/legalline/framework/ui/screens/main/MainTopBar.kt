package com.example.legalline.framework.ui.screens.main

import androidx.compose.foundation.text.BasicText
import androidx.compose.material.ScaffoldState
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import com.example.legalline.R
import com.example.legalline.framework.viewmodels.MainViewModel

@Composable
fun MainTopBar(scaffoldState: ScaffoldState, mainViewModel: MainViewModel) {
    val scope = rememberCoroutineScope()
    TopAppBar(
        title = { BasicText(text = stringResource(id = R.string.app_name)) },
        navigationIcon = { MenuButton(scaffoldState, scope) },
        actions = { FavoriteButton(mainViewModel) },
        backgroundColor = colorResource(id = R.color.Turquoise),
    )
}