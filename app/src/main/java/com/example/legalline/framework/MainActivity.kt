package com.example.legalline.framework

import android.os.Bundle
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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

        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.statusBarColor = resources.getColor(R.color.black)
        // con esta linea se quita el bug de al rotar la pantalla en mi xiaomi quedaba en blanco
        window.decorView.post { window.setBackgroundDrawableResource(android.R.color.transparent) }

        setContent {
            val defaultTheme = isSystemInDarkTheme()
            var isDarkTheme = remember{ mutableStateOf(defaultTheme) }
            LegalLineTheme(
                darkTheme = isDarkTheme.value
            ){
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "mainScreen"){
                    composable("mainScreen"){
                        MainScreen(navController, isDarkTheme)
                    }
                    composable("favorites"){
                        FavoritesScreen(navController, isDarkTheme)
                    }
                    composable(
                        route = "favoritesConver/{idNameFavorite}",
                        arguments = listOf(
                            navArgument("idNameFavorite"){type = NavType.StringType}
                        )
                    ){
                        ConversationScreen(navController, isDarkTheme)
                    }
                }
            }
        }
    }
}