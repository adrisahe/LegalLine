package com.example.legalline.framework.ui.screens.favorites

import androidx.compose.material.ScaffoldState
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import com.example.legalline.R
import com.example.legalline.framework.ui.screens.main.MenuButton

@Composable
fun FavoriteTopBar(scaffoldState: ScaffoldState) {
    val scope = rememberCoroutineScope()
    TopAppBar(
        title = {
            Text(
                text = stringResource(id = R.string.app_name),
                fontFamily = FontFamily(Font(R.font.opensans_condensed_regular))
            )
        },
        navigationIcon = { MenuButton(scaffoldState, scope) },
        backgroundColor = colorResource(id = R.color.Turquoise),
    )
}