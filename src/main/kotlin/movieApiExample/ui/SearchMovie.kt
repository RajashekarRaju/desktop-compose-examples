package movieApiExample.ui

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import movieApiExample.model.Movie
import movieApiExample.repository.AppRepository
import org.jetbrains.skija.impl.Log


@ExperimentalFoundationApi
@Composable
fun searchList(
    repository: AppRepository = AppRepository()
) {

    Surface {

        Column(
            modifier = Modifier.fillMaxSize().padding(16.dp).verticalScroll(
                state = ScrollState(1), enabled = true
            )
        ) {
            categoryTitle("Search")
            gridPoster(repository.getQuerySearchedMovies())
        }
    }
}

@ExperimentalFoundationApi
@Composable
fun gridPoster(
    movieList: List<Movie>
) {
    LazyRow (
        horizontalArrangement = Arrangement.spacedBy(20.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        items(movieList) { movie ->
            moviesGrid(movie)
        }
    }
}

@Composable
fun moviesGrid(
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