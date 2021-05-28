package movieApiExample.network

import movieApiExample.model.Movie
import java.net.MalformedURLException
import java.net.URI
import java.net.URL


// https://api.themoviedb.org/3/movie/popular?api_key=YOUR_API_KEY

private const val SCHEME_AUTHORITY = "https://api.themoviedb.org/"
private const val APPEND_PATH_VERSION = "3/"
private const val APPEND_PATH_MOVIE = "movie/"
private const val API_PARAM = "api_key"
private const val API_KEY = ""

private const val APPEND_URL_ENDPOINT = "?"
private const val APPEND_QUERY_PARAMETER = "="

const val APPEND_PATH_POPULAR = "popular"
const val MOVIE_PATH_TOP_RATED = "top_rated"
const val APPEND_PATH_UPCOMING = "upcoming"
const val APPEND_PATH_NOW_PLAYING = "now_playing"
const val APPEND_PATH_SIMILAR = "similar"

private const val APPEND_PATH_PERSON = "person"
private const val REVIEWS_PATH = "reviews"
private const val CAST_PATH = "credits"

private const val commonPath = SCHEME_AUTHORITY + APPEND_PATH_VERSION + APPEND_PATH_MOVIE
private const val assignApiKey = API_PARAM + APPEND_QUERY_PARAMETER + API_KEY

/**
 * @return The URL to use to query the movie database server.
 *
 * movieType = Replace this string with "popular", "now_playing", "top_rated".
 */
fun movieUriBuilder(
    movieType: String
): URL? {

    val builtUrl = commonPath + movieType + APPEND_URL_ENDPOINT + assignApiKey
    val baseUri = URI.create(builtUrl)
    var url: URL? = null

    try {
        url = URL(baseUri.toString())
    } catch (e: MalformedURLException) {
        e.printStackTrace()
    }
    return url
}

fun buildMovieType(movieType: String): List<Movie> {
    val builtUrl = movieUriBuilder(movieType).toString()
    return getJsonMovieData(createUrl(builtUrl))
}
