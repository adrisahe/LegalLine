package com.example.legalline.framework.ui.screens.main

import androidx.compose.material.MaterialTheme
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import com.example.legalline.R
import com.example.legalline.framework.ui.common.MenuButton
import com.example.legalline.framework.viewmodels.MainViewModel

@Composable
fun MainTopBar(
    scaffoldState: ScaffoldState,
    mainViewModel: MainViewModel
) {
    val scope = rememberCoroutineScope()
    TopAppBar(
        title = {
            Text(
                text = stringResource(id = R.string.app_name),
                fontFamily = FontFamily(Font(R.font.opensans_condensed_bold))
            )
                },
        navigationIcon = { MenuButton(scaffoldState, scope) },
        actions = { FavoriteButton(mainViewModel) },
        backgroundColor = MaterialTheme.colors.primary,
    )
}