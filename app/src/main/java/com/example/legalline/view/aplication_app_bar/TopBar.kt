package com.example.legalline.view.main

import android.annotation.SuppressLint
import androidx.compose.foundation.text.BasicText
import androidx.compose.material.Scaffold
import androidx.compose.material.TopAppBar
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import com.example.legalline.R
import com.example.legalline.viewModels.MainViewModel

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun TopBar(mainViewModel: MainViewModel, navController: NavHostController) {
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            TopAppBar(
                title = { BasicText(text = stringResource(id = R.string.app_name)) },
                navigationIcon = { MenuButton(scaffoldState, scope) },
                backgroundColor = colorResource(id = R.color.Turquoise)
            )
        },
        drawerContent = {
            SideMenu(navController)
        },
        drawerBackgroundColor = colorResource(id = R.color.Turquoise)
    ) {
        ContentMainScreen(mainViewModel)
    }
}