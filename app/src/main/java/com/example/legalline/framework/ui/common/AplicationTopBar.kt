package com.example.legalline.framework.ui.screens.aplication_app_bar

import android.annotation.SuppressLint
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.navigation.NavHostController
import com.example.legalline.framework.ui.common.SideMenu

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun AplicationTopBar(
    navController: NavHostController,
    scaffoldState: ScaffoldState,
    isDarkTheme: MutableState<Boolean>,
    language: MutableState<java.util.Locale>,
    topAppBar: @Composable () -> Unit,
    content: @Composable () -> Unit
) {
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            topAppBar()
        },
        drawerContent = {
            SideMenu(navController, scaffoldState, isDarkTheme, language)
        },
        drawerBackgroundColor = MaterialTheme.colors.primary
    ) {
        content()
    }
}