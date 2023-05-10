package com.example.legalline.framework

import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.legalline.R
import com.example.legalline.framework.ui.screens.conversation.ConversationScreen
import com.example.legalline.framework.ui.screens.main.MainScreen
import com.example.legalline.framework.ui.theme.LegalLineTheme
import com.example.legalline.framework.ui.screens.favorites.FavoritesScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val window: Window = window
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.statusBarColor = resources.getColor(R.color.Turquoise)

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
                    composable(
                        route = "favoritesConver/{idNameFavorite}",
                        arguments = listOf(
                            navArgument("idNameFavorite"){type = NavType.StringType}
                        )
                    ){
                        ConversationScreen(navController)
                    }
                }
            }
        }
    }
}