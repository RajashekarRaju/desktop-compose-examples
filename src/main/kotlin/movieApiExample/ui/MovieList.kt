package movieApiExample.ui

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import movieApiExample.loadNetworkImage
import movieApiExample.model.Movie
import movieApiExample.network.*


@ExperimentalAnimationApi
@Composable
fun moviesList() {

    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        title("Popular")
        poster(buildMovieType(APPEND_PATH_POPULAR))

        title("Top Rated")
        poster(buildMovieType(MOVIE_PATH_TOP_RATED))

        title("Now Playing")
        poster(buildMovieType(APPEND_PATH_NOW_PLAYING))

        title("Upcoming")
        poster(buildMovieType(APPEND_PATH_UPCOMING))
    }
}

@Composable
fun title(
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
    movie: Movie
) {
    Card(
        shape = MaterialTheme.shapes.medium
    ) {
        Image(
            bitmap = loadNetworkImage(movie.bannerUrl),
            contentDescription = "Movie Poster",
            modifier = Modifier.size(width = 120.dp, height = 180.dp),
            contentScale = ContentScale.Crop
        )
    }
}