package movieApiExample.ui

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import movieApiExample.model.Movie
import movieApiExample.repository.AppRepository
import org.jetbrains.skija.impl.Log

@ExperimentalAnimationApi
@Composable
fun moviesList(
    repository: AppRepository = AppRepository()
) {

    Surface {

        Column(
            modifier = Modifier.fillMaxSize().padding(16.dp).verticalScroll(
                state = ScrollState(1), enabled = true
            )
        ) {
            categoryTitle("Popular")
            poster(repository.getPopularMovies())

            categoryTitle("Top Rated")
            poster(repository.getTopRatedMovies())

            categoryTitle("Now Playing")
            poster(repository.getNowPlayingMovies())

            categoryTitle("Upcoming")
            poster(repository.getUpcomingMovies())
        }
    }
}

@Composable
fun categoryTitle(
    movieType: String
) {
    Text(
        text = movieType,
        style = MaterialTheme.typography.h4,
        modifier = Modifier.padding(top = 20.dp, bottom = 8.dp)
    )
}

@Composable
fun poster(
    movieList: List<Movie>
) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(20.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        items(movieList) { movie ->
            moviesRow(movie)
        }
    }
}

@Composable
fun moviesRow(
    movie: Movie,
    repository: AppRepository = AppRepository()
) {
    Card(
        shape = MaterialTheme.shapes.medium
    ) {
        Image(
            bitmap = repository.getImage(movie.bannerUrl),
            contentDescription = "Movie Poster",
            contentScale = ContentScale.Crop,
            modifier = Modifier.size(width = 120.dp, height = 180.dp).clickable {
                Log.error("Movie id is ${movie.movieId}")
            },
        )
    }
}