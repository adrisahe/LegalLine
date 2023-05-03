package com.example.legalline.framework

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.legalline.R
import com.example.legalline.framework.ui.screens.main.MainScreen
import com.example.legalline.framework.viewmodels.MainViewModel
import com.example.legalline.framework.ui.theme.LegalLineTheme
import com.example.legalline.framework.ui.screens.favorites.FavoritesScreen
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //val mainViewModel: MainViewModel by viewModels()

        setContent {
            LegalLineTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "mainScreen"){
                    composable("mainScreen"){
                        MainScreen(navController)
                    }
                    composable("favorites"){
                        FavoritesScreen(navController)
                    }
                }
            }
        }
    }
}