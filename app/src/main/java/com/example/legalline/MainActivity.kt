package com.example.legalline

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.legalline.view.main.MainScreen
import com.example.legalline.viewModels.MainViewModel
import com.example.legalline.viewModels.MainViewModelFactory
import com.example.legalline.ui.theme.LegalLineTheme
import com.example.legalline.view.favorites.FavoritesScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val mainViewModel: MainViewModel by viewModels {
            MainViewModelFactory(resources.getString(R.string.apy_key))
        }

        setContent {
            LegalLineTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "mainScreen"){
                    composable("mainScreen"){
                        MainScreen(mainViewModel, navController)
                    }
                    composable("favorites"){
                        FavoritesScreen()
                    }
                }
            }
        }
    }
}