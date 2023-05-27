package com.example.legalline.framework.ui.common

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.ScaffoldState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import com.example.legalline.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import java.util.Locale

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun MenuButton(scaffoldState: ScaffoldState, scope: CoroutineScope) {
    val keyboard = LocalSoftwareKeyboardController.current
    IconButton(onClick = {
        scope.launch {
            keyboard?.hide()
            scaffoldState.drawerState.open()
        }
    }) {
        Icon(
            imageVector = Icons.Default.Menu,
            contentDescription = stringResource(id = R.string.iconMenu)
        )
    }
}