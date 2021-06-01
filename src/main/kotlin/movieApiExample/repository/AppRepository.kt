package movieApiExample.repository

import androidx.compose.ui.graphics.ImageBitmap
import movieApiExample.loadNetworkImage
import movieApiExample.model.Cast
import movieApiExample.model.Movie
import movieApiExample.network.*

class AppRepository {

    // Salt -> 27576
    // JW3 -> 458156
    // Telugu -> 454292
    val parseMovieId: Int = 454292

    fun getPopularMovies(): List<Movie> = buildMovieListType(TYPE_MOVIES_POPULAR)
    fun getTopRatedMovies(): List<Movie> = buildMovieListType(TYPE_MOVIES_TOP_RATED)
    fun getNowPlayingMovies(): List<Movie> = buildMovieListType(TYPE_MOVIES_NOW_PLAYING)
    fun getUpcomingMovies(): List<Movie> = buildMovieListType(TYPE_MOVIES_UPCOMING)

    fun getRecommendedMovies(movieId: Int = parseMovieId): List<Movie> {
        return buildRecommendedMovies(movieId)
    }

    fun getSimilarMovies(movieId: Int = parseMovieId): List<Movie> {
        return buildSimilarMovies(movieId)
    }

    fun getMovieCastCredits(movieId: Int = parseMovieId): List<Cast> {
        return buildMovieCredits(movieId)
    }

    fun getQuerySearchedMovies(query: String): List<Movie> {
        return buildQuerySearchedMovies(query)
    }

    fun getImage(imageUrl: String?): ImageBitmap {
        return loadNetworkImage(imageUrl)
    }
}