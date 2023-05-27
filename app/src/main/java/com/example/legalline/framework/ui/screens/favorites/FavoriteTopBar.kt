package com.example.legalline.framework.ui.screens.favorites

import androidx.compose.material.MaterialTheme
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import com.example.legalline.R
import com.example.legalline.data.utils.updateLanguage
import com.example.legalline.framework.ui.common.MenuButton
import java.util.Locale

@Composable
fun FavoriteTopBar(
    scaffoldState: ScaffoldState,
    language: MutableState<Locale>,
    removeAllFavorites: () -> Unit
) {
    val scope = rememberCoroutineScope()
    TopAppBar(
        title = {
            updateLanguage(LocalContext.current, language)
            Text(
                text = stringResource(id = R.string.favorites),
                fontFamily = FontFamily(Font(R.font.opensans_condensed_bold))
            )
        },
        actions = { DeleteAllButton(removeAllFavorites)},
        navigationIcon = { MenuButton(scaffoldState, scope) },
        backgroundColor = MaterialTheme.colors.primary,
    )
}