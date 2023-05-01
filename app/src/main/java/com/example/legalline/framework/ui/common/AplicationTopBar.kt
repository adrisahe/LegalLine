package com.example.legalline.framework.ui.screens.aplication_app_bar

import android.annotation.SuppressLint
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.colorResource
import androidx.navigation.NavHostController
import com.example.legalline.R
import com.example.legalline.framework.ui.screens.main.SideMenu

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