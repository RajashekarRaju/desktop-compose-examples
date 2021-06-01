package movieApiExample.ui

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.unit.dp
import movieApiExample.minutesToHours
import movieApiExample.model.Cast
import movieApiExample.model.MovieDetail
import movieApiExample.network.buildMovieDetails
import movieApiExample.repository.AppRepository
import movieApiExample.truncateNumber
import org.jetbrains.skija.impl.Log


@ExperimentalAnimationApi
@Composable
fun movieDetail(
    movie: MovieDetail? = buildMovieDetails(AppRepository().parseMovieId),
    repository: AppRepository = AppRepository()
) {

    Box(
        modifier = Modifier.fillMaxWidth()
    ) {

        Image(
            bitmap = repository.getImage(movie?.bannerUrl),
            contentDescription = "Movie Banner",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop,
            alpha = 0.3F
        )

        Column(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp).verticalScroll(
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
                        style = MaterialTheme.typography.subtitle1
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = "Release Date : ${movie?.releaseDate}",
                        modifier = Modifier,
                        style = MaterialTheme.typography.h6
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Image(
                            imageResource("time_duration.png"),
                            contentDescription = "",
                            modifier = Modifier.size(32.dp)
                        )

                        Spacer(modifier = Modifier.width(12.dp))

                        Text(
                            text = minutesToHours(movie?.runtime!!),
                            modifier = Modifier,
                            style = MaterialTheme.typography.h6
                        )
                    }
                }

                Column(
                    horizontalAlignment = Alignment.End,
                    modifier = Modifier.padding(horizontal = 16.dp).fillMaxWidth()
                ) {
                    Text(
                        text = "Budget",
                        modifier = Modifier,
                        style = MaterialTheme.typography.subtitle2
                    )
                    Text(
                        text = truncateNumber(movie?.budget),
                        modifier = Modifier,
                        style = MaterialTheme.typography.subtitle1
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = "Revenue",
                        modifier = Modifier,
                        style = MaterialTheme.typography.subtitle2
                    )
                    Text(
                        text = truncateNumber(movie?.revenue),
                        modifier = Modifier,
                        style = MaterialTheme.typography.subtitle1
                    )
                }
            }

            categoryTitle("Casting")
            castProfile(repository.getMovieCastCredits())

            Spacer(modifier = Modifier.height(12.dp))

            categoryTitle("Recommended Movies")
            poster(repository.getRecommendedMovies())

            Spacer(modifier = Modifier.height(12.dp))

            categoryTitle("Similar Movies")
            poster(repository.getSimilarMovies())

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

    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(
            bitmap = repository.getImage(cast.profileUrl),
            contentDescription = "Actor Image",
            contentScale = ContentScale.Crop,
            modifier = Modifier.size(120.dp).clickable {
                Log.error("Cast id is ${cast.castId}")
            }.clip(shape = CircleShape)
        )

        Text(
            text = "${cast.name}",
            modifier = Modifier.padding(vertical = 8.dp),
            style = MaterialTheme.typography.subtitle2
        )
    }

}
