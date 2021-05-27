package movieApiExample.ui

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import movieApiExample.model.Movie
import movieApiExample.network.loadNetworkImage


@ExperimentalAnimationApi
@Composable
fun moviesList(
    movieData: List<Movie>
) {
    Scaffold(
        topBar = {
            Text(
                text = "Movies from TMDB Api",
                style = MaterialTheme.typography.h2,
                modifier = Modifier.padding(vertical = 20.dp)
            )
        }
    ) {
        moviesListBody(movieData)
    }
}

@ExperimentalAnimationApi
@Composable
fun moviesListBody(
    movieData: List<Movie>
) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(20.dp),
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        items(movieData) { movie ->
            movieRow(movie)
        }
    }
}

@Composable
fun movieRow(
    movie: Movie
) {
    Card(
        Modifier.fillMaxWidth(),
        shape = MaterialTheme.shapes.medium
    ) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth(),
            //.padding(24.dp),
            verticalArrangement = Arrangement.Center
        ) {

            Image(
                bitmap = loadNetworkImage(movie.bannerUrl),
                contentDescription = "",
                modifier = Modifier.size(width = 300.dp, height = 200.dp),
                contentScale = ContentScale.Crop
            )

            Spacer(Modifier.height(8.dp))

            Text(
                text = movie.title!!,
                style = MaterialTheme.typography.h5,
                color = Color.Gray,
                modifier = Modifier.width(200.dp).align(Alignment.CenterHorizontally),
                textAlign = TextAlign.Center
            )

            Spacer(Modifier.height(24.dp))

            Text(
                text = movie.releaseDate!!,
                style = MaterialTheme.typography.h6,
                color = Color.Gray
            )

            Spacer(Modifier.height(24.dp))

            Text(
                text = movie.overView!!,
                style = MaterialTheme.typography.subtitle1,
                color = Color.Gray,
                modifier = Modifier.width(200.dp).height(300.dp)
            )
        }
    }
}