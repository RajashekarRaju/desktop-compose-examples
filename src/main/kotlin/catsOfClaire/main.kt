package catsOfClaire

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.desktop.Window
import catsOfClaire.ui.cats.catsList
import catsOfClaire.ui.theme.commonDesktopTheme

@ExperimentalAnimationApi
fun main() = Window {
    commonDesktopTheme {
        catsList()
    }
}

