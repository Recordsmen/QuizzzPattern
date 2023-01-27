package com.quizzz_Walking_Dead.quizzzpattern.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorPalette = darkColors(
    primary = Black,
    primaryVariant = Black,
    onPrimary = Black,
    secondary = Black,
    secondaryVariant = Black,
    onSecondary = Black
)

private val LightColorPalette = lightColors(
    primary = Color.Black,
    primaryVariant = Color.Black,
    onPrimary = Color.White,
    secondary = Purple400,
    secondaryVariant = Purple700,
    onSecondary = Black
)

@Composable
fun QuizzzPatternTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
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
