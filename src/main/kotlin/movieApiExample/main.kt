package movieApiExample

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.desktop.Window
import catsOfClaire.ui.theme.commonDesktopTheme
import movieApiExample.model.Movie
import movieApiExample.network.APPEND_PATH_POPULAR
import movieApiExample.network.createUrl
import movieApiExample.network.getJsonMovieData
import movieApiExample.network.movieUriBuilder
import movieApiExample.ui.moviesList


@ExperimentalAnimationApi
fun main() {

    Window {
        val builtUrl = movieUriBuilder(APPEND_PATH_POPULAR).toString()
        val movieData: List<Movie> = getJsonMovieData(createUrl(builtUrl))

        commonDesktopTheme {
            moviesList(movieData)
        }
    }
}
