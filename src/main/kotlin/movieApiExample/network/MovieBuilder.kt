package movieApiExample.network

import movieApiExample.model.Cast
import movieApiExample.model.Movie
import movieApiExample.model.MovieDetail
import org.jetbrains.skija.impl.Log
import java.net.URI
import java.net.URL

// https://api.themoviedb.org/3/movie/popular?api_key=
// https://api.themoviedb.org/3/movie/454292/similar?api_key=
// https://api.themoviedb.org/3/search/movie?api_key=&query=salt
// https://api.themoviedb.org/3/movie/454292/credits?api_key=
// https://api.themoviedb.org/3/movie/27576?api_key=

fun buildMovieListType(
    movieType: String
): List<Movie> {
    val builtUrl = movieTypeUriBuilder(movieType)
    return getJsonMovieData(createUrl(builtUrl))
}

fun buildMovieDetails(
    movieId: Int
): MovieDetail? {
    val builtUrl = movieDetailUriBuilder(movieId)
    return getJsonSelectedMovieData(createUrl(builtUrl))
}

fun buildRecommendedMovies(
    movieId: Int
): List<Movie> {
    val builtUrl = movieRecommendationsUriBuilder(movieId)
    return getJsonMovieData(createUrl(builtUrl))
}

fun buildSimilarMovies(
    movieId: Int
): List<Movie> {
    val builtUrl = movieSimilarUriBuilder(movieId)
    return getJsonMovieData(createUrl(builtUrl))
}

fun buildMovieCredits(
    movieId: Int
): List<Cast> {
    val builtUrl = movieCreditsUriBuilder(movieId)
    return getJsonMovieCreditsData(createUrl(builtUrl))
}

fun buildQuerySearchedMovies(
    query: String
): List<Movie> {
    val builtUrl = movieSearchQueryBuilder(query)
    return getJsonMovieData(createUrl(builtUrl))
}

/**
 * movieType = Replace this string with "popular", "now_playing", "top_rated", "upcoming".
 *
 * https://api.themoviedb.org/3/movie/popular?api_key=YOUR_API_KEY
 */
fun movieTypeUriBuilder(
    movieType: String
): URL {
    val builtUrl = "$MOVIE_PATH$movieType$APPEND_URL_ENDPOINT$assignApiKey"
    val baseUri = URI.create(builtUrl)
    return URL(baseUri.toString())
}

/**
 * https://api.themoviedb.org/3/movie/27576?api_key=
 */
fun movieDetailUriBuilder(
    movieId: Int
): URL {
    val builtUrl = "$MOVIE_PATH$movieId$APPEND_URL_ENDPOINT$assignApiKey"
    val baseUri = URI.create(builtUrl)
    return URL(baseUri.toString())
}

/**
 * https://api.themoviedb.org/3/movie/454292/recommendations?api_key=
 */
fun movieRecommendationsUriBuilder(
    movieId: Int
): URL {
    val builtUrl = "$MOVIE_PATH$movieId/$APPEND_PATH_RECOMMENDATIONS$APPEND_URL_ENDPOINT$assignApiKey"
    val baseUri = URI.create(builtUrl)
    return URL(baseUri.toString())
}

/**
 * https://api.themoviedb.org/3/movie/454292/recommendations?api_key=
 */
fun movieSimilarUriBuilder(
    movieId: Int
): URL {
    val builtUrl = "$MOVIE_PATH$movieId/$APPEND_PATH_SIMILAR$APPEND_URL_ENDPOINT$assignApiKey"
    val baseUri = URI.create(builtUrl)
    return URL(baseUri.toString())
}

/**
 * https://api.themoviedb.org/3/search/movie?api_key=&query=salt
 */
fun movieSearchQueryBuilder(
    query: String
): URL {
    val assignQuery = "$QUERY_PARAM$APPEND_QUERY_PARAMETER$query"
    val builtUrl = "$SEARCH_BASE_PATH$assignApiKey$APPEND_PARAMETER$assignQuery"
    val baseUri = URI.create(builtUrl)
    Log.error("Search query is $baseUri")
    return URL(baseUri.toString())
}

/**
 * https://api.themoviedb.org/3/movie/454292/recommendations?api_key=
 */
fun movieCreditsUriBuilder(
    movieId: Int
): URL {
    val builtUrl = "$MOVIE_PATH$movieId/$APPEND_PATH_CREDITS$APPEND_URL_ENDPOINT$assignApiKey"
    val baseUri = URI.create(builtUrl)
    return URL(baseUri.toString())
}