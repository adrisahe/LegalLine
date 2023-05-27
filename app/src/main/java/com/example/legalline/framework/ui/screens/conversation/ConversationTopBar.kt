package com.example.legalline.framework.ui.screens.conversation

import androidx.compose.material.MaterialTheme
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import com.example.legalline.framework.ui.common.MenuButton
import com.example.legalline.framework.viewmodels.ConversationViewModel

@Composable
fun ConversationTopBar(vm: ConversationViewModel, scaffoldState: ScaffoldState) {
    val nameFavorite by vm.nameFavorite.collectAsState()
    val scope = rememberCoroutineScope()
    TopAppBar(
        title = { Text(text = nameFavorite) },
        navigationIcon = { MenuButton(scaffoldState, scope) },
        actions = { EditFavoriteButton(vm) },
        backgroundColor = MaterialTheme.colors.primary,
    )
}