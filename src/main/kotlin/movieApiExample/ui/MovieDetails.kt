package movieApiExample.ui

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import movieApiExample.model.Cast
import movieApiExample.model.MovieDetail
import movieApiExample.repository.AppRepository
import org.jetbrains.skija.impl.Log


@ExperimentalAnimationApi
@Composable
fun movieDetail(
    movie: MovieDetail?,
    repository: AppRepository = AppRepository()
) {

    Box {

        Image(
            bitmap = repository.getImage(movie?.bannerUrl),
            contentDescription = "Movie Banner",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop,
            alpha = 0.2F
        )

        Column(
            modifier = Modifier.padding(horizontal = 16.dp).verticalScroll(
                state = ScrollState(1), enabled = true
            )
        ) {

            Spacer(modifier = Modifier.height(16.dp))

            Row {

                Card(
                    shape = MaterialTheme.shapes.medium
                ) {
                    Image(
                        bitmap = repository.getImage(movie?.posterUrl),
                        contentDescription = "Movie Poster",
                        modifier = Modifier.width(160.dp).height(240.dp),
                        contentScale = ContentScale.Crop
                    )
                }

                // Title & Overview
                Column(
                    modifier = Modifier.padding(horizontal = 16.dp),
                ) {

                    Text(
                        text = movie?.title.toString(),
                        style = MaterialTheme.typography.h4
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = movie?.overView.toString(),
                        modifier = Modifier.width(560.dp),
                        style = MaterialTheme.typography.h6
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = "Release Date : ${movie?.releaseDate}",
                        modifier = Modifier,
                        style = MaterialTheme.typography.h5
                    )
                }
            }

            categoryTitle("Casting")
            castProfile(repository.getMovieCastCredits())

            Spacer(modifier = Modifier.height(12.dp))

            categoryTitle("Recommended Movies")
            poster(repository.getRecommendedMovies())

            Spacer(modifier = Modifier.height(16.dp))
        }
    }

}

@Composable
fun castProfile(
    castList: List<Cast>
) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(20.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        items(castList) { cast ->
            castRow(cast)
        }
    }
}

@Composable
fun castRow(
    cast: Cast,
    repository: AppRepository = AppRepository()
) {
    Card(
        shape = MaterialTheme.shapes.medium
    ) {
        Image(
            bitmap = repository.getImage(cast.profileUrl),
            contentDescription = "Actor Image",
            contentScale = ContentScale.Crop,
            modifier = Modifier.size(width = 120.dp, height = 180.dp).clickable {
                Log.error("Cast id is ${cast.castId}")
            },
        )
    }
}
