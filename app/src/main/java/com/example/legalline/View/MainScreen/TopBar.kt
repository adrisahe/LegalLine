package com.example.legalline.View.MainScreen

import android.annotation.SuppressLint
import androidx.compose.foundation.text.BasicText
import androidx.compose.material.Scaffold
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.example.legalline.R
import com.example.legalline.ViewModel.MainViewModel.MainViewModel

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun TopBar(mainViewModel: MainViewModel) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { BasicText(text = stringResource(id = R.string.app_name)) },
            )
        }
    ) {
        ContentMainScreen(mainViewModel)
    }
}