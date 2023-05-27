package com.example.legalline.framework.ui.screens.conversation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.legalline.framework.ui.screens.aplication_app_bar.AplicationTopBar
import com.example.legalline.framework.viewmodels.ConversationViewModel

@Composable
fun ConversationScreen(
    navController: NavHostController,
    isDarkTheme: MutableState<Boolean>,
    language: MutableState<java.util.Locale>,
    vm: ConversationViewModel = hiltViewModel(),
) {
    vm.setLanguage(language.value.language)
    val scaffoldState = rememberScaffoldState()
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        AplicationTopBar(navController, scaffoldState, isDarkTheme, language, {
            ConversationTopBar(vm, scaffoldState)
        }) {
            SaveConversation(vm, language)
        }
    }
}