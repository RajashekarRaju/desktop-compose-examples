package movieApiExample.ui

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import movieApiExample.model.Movie
import movieApiExample.repository.AppRepository
import org.jetbrains.skija.impl.Log


@ExperimentalAnimationApi
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

            var searchText by rememberSaveable { mutableStateOf("salt") }
            var searchStarted by rememberSaveable { mutableStateOf(false) }

            TextField(
                value = searchText,
                onValueChange = {
                    searchText = it
                    searchStarted = !searchStarted
                },
                textStyle = MaterialTheme.typography.h3,
                singleLine = true,
                maxLines = 1,
                modifier = Modifier
                    .padding(24.dp)
                    .width(600.dp).wrapContentHeight()
                    .clip(RoundedCornerShape(20.dp))
                    .border(1.dp, Color.Gray, RectangleShape)
                    .background(Color.Gray, RectangleShape),
            )

            Spacer(modifier = Modifier.height(60.dp))

            categoryTitle("Search")
            if (searchStarted) {
                gridPoster(repository.getQuerySearchedMovies(searchText))
            }
        }
    }
}

@ExperimentalAnimationApi
@ExperimentalFoundationApi
@Composable
fun gridPoster(
    movieList: List<Movie>
) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(20.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        items(movieList) { movie ->
            moviesGrid(movie)
        }
    }
}

@ExperimentalAnimationApi
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
            }
        )
    }
}