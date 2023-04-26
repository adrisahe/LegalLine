package com.example.legalline.view.aplication_app_bar

import android.annotation.SuppressLint
import androidx.compose.foundation.text.BasicText
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.TopAppBar
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import com.example.legalline.R
import com.example.legalline.view.main.ContentMainScreen
import com.example.legalline.view.main.MenuButton
import com.example.legalline.view.main.SideMenu
import com.example.legalline.viewModels.MainViewModel
import kotlinx.coroutines.CoroutineScope

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun AplicationTopBar(
    navController: NavHostController,
    scaffoldState: ScaffoldState,
    topAppBar: @Composable () -> Unit,
    content: @Composable () -> Unit
) {
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            topAppBar()
        },
        drawerContent = {
            SideMenu(navController)
        },
        drawerBackgroundColor = colorResource(id = R.color.Turquoise)
    ) {
        content()
    }
}