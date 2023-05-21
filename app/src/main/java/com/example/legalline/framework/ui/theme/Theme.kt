package com.example.legalline.framework.ui.theme

import android.annotation.SuppressLint
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorPalette = darkColors(
    primary = actionBarDark,
    primaryVariant = Purple700,
    secondary = Teal200,
    secondaryVariant = sendMessageDark,
    onError = Color(0xFFE6FFF5)
)

@SuppressLint("ConflictingOnColor")
private val LightColorPalette = lightColors(
    primary = actionBarLight,
    primaryVariant = Purple700,
    secondary = Teal200,
    secondaryVariant = sendMessageLight,
    background = Color(0xFFE6FFF5),
    onError = Color(0xFF2B2C2C),

    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

@Composable
fun LegalLineTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}