package movieApiExample

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.desktop.Window
import catsOfClaire.ui.theme.commonDesktopTheme
import movieApiExample.ui.moviesList


@ExperimentalAnimationApi
fun main() {

    Window {
        commonDesktopTheme {
            moviesList()
        }
    }
}
