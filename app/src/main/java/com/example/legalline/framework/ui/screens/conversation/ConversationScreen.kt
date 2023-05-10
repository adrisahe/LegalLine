package com.example.legalline.framework.ui.screens.conversation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.legalline.framework.ui.screens.aplication_app_bar.AplicationTopBar
import com.example.legalline.framework.viewmodels.ConversationViewModel

@Composable
fun ConversationScreen(
    navController: NavHostController,
    vm: ConversationViewModel = hiltViewModel(),
) {
    val scaffoldState = rememberScaffoldState()
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        AplicationTopBar(navController, scaffoldState, {
            ConversationTopBar(vm, scaffoldState)
        }) {
            SaveConversation(vm)
        }
    }
}