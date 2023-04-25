package com.example.legalline.view.main

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.ScaffoldState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun MenuButton(scaffoldState: ScaffoldState, scope: CoroutineScope) {
    IconButton(onClick = {
        scope.launch {
            scaffoldState.drawerState.open()
        }
    }) {
        Icon(imageVector = Icons.Default.Menu, contentDescription = "Menu Button")
    }
}