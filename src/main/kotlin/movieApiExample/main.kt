package movieApiExample

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.desktop.Window
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.Surface
import catsOfClaire.ui.theme.commonDesktopTheme
import movieApiExample.ui.movieDetail


@ExperimentalFoundationApi
@ExperimentalAnimationApi
fun main() = Window {

    commonDesktopTheme(true) {

        Surface {

            // Shows list of movies with categories
            // moviesList()

            // Shows detail for movie based on passed ID value
            // Test my movie ID -> 27576
            // val movieId = AppRepository().parseMovieId
            // val movieDetails: MovieDetail? = buildMovieDetails(movieId)
            movieDetail()

            // searchList()
        }
    }
}

//@ExperimentalAnimationApi
//@Composable
//fun navScreen() {
//
//    var showDetails by rememberSaveable { mutableStateOf(false) }
//
//    if (!showDetails) {
//        moviesList()
//    } else {
//        movieDetail()
//    }
//}
