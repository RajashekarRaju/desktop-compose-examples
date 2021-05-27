package catsOfClaire.ui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColors(
    primary = grey500,
    primaryVariant = grey700,
    secondary = grey500,
    secondaryVariant = grey300,
)

private val LightColorPalette = lightColors(
    primary = grey700,
    primaryVariant = grey900,
    secondary = grey700,
    secondaryVariant = grey900,
    background = grey100
)

@Composable
fun commonDesktopTheme(
    content: @Composable () -> Unit
) {
    val colors = DarkColorPalette

    MaterialTheme(
        colors = colors,
        typography = typography,
        shapes = shapes,
        content = content
    )
}
