package movieApiExample.network

import movieApiExample.model.Cast
import movieApiExample.model.Movie
import movieApiExample.model.MovieDetail
import org.jetbrains.skija.impl.Log
import org.json.JSONException
import org.json.JSONObject


/**
 * Return a list of [Movie] objects that has been built up from parsing a JSON response.
 */
fun getJsonMovieCreditsData(
    jsonResponse: String?
): List<Cast> {

    val castData: MutableList<Cast> = ArrayList()

    try {
        // Create a JSONObject from the JSON response string
        val baseJson = JSONObject(jsonResponse)
        val castArray = baseJson.getJSONArray("cast")
        for (i in 0 until castArray.length()) {

            // Create a JSONObject from the JSON response string
            val jsonObject = castArray.getJSONObject(i)

            val castId: Int = jsonObject.getInt("id")
            val name: String? = jsonObject.getString("name")
            val popularity: Double = jsonObject.getDouble("popularity")
            val character: String? = jsonObject.getString("character")
            val profilePathUrl: String? = jsonObject.getString("profile_path")
            val profileUrl: String = IMAGE_PATH_URL + profilePathUrl

            // Create a new {@link Movie} object with required properties
            val currentCast = Cast(castId, name, profileUrl, popularity, character)
            // Add the new {@link Movie} to the list of movies.
            castData.add(currentCast)
        }
    } catch (e: JSONException) {
        Log.error("Problem parsing the Cast JSON results $e")
    }
    // Return the list of Movies
    return castData
}


/**
 * Return a list of [Movie] objects that has been built up from parsing a JSON response.
 */
fun getJsonMovieData(
    jsonResponse: String?
): List<Movie> {

    val movieData: MutableList<Movie> = ArrayList()

    try {
        // Create a JSONObject from the JSON response string
        val baseJson = JSONObject(jsonResponse)
        val resultsArray = baseJson.getJSONArray("results")
        for (i in 0 until resultsArray.length()) {

            // Create a JSONObject from the JSON response string
            val jsonObject = resultsArray.getJSONObject(i)

            val movieId: Int = jsonObject.getInt("id")
            val title: String? = jsonObject.getString("title")
            val bannerEndPoint: String? = jsonObject.getString("poster_path")
            val bannerUrl: String = IMAGE_PATH_URL + bannerEndPoint

            // Create a new {@link Movie} object with required properties
            val currentMovie = Movie(movieId, title, bannerUrl)
            // Add the new {@link Movie} to the list of movies.
            movieData.add(currentMovie)
        }
    } catch (e: JSONException) {
        Log.error("Problem parsing the Movie JSON results $e")
    }
    // Return the list of Movies
    return movieData
}

/**
 * Salt movie --> ID = 27576
 * Bahubali movie --> ID = 256040
 *
 * Get movie by ID
 * https://api.themoviedb.org/3/search/movie?api_key=&query=salt
 */
fun getJsonSelectedMovieData(
    jsonResponse: String?
): MovieDetail? {

    var movieDetail: MovieDetail? = null

    try {
        val jsonObject = JSONObject(jsonResponse)

        val movieId: Int = jsonObject.getInt("id")
        val title: String? = jsonObject.getString("title")
        val overView: String? = jsonObject.getString("overview")
        val releaseDate: String? = jsonObject.getString("release_date")
        val posterEndPoint: String? = jsonObject.getString("poster_path")
        val bannerEndPoint: String? = jsonObject.getString("backdrop_path")
        val budget: Long = jsonObject.getLong("budget")
        val revenue: Long = jsonObject.getLong("revenue")
        val runtime: Int = jsonObject.getInt("runtime")
        val bannerUrl: String = IMAGE_PATH_BANNER_URL + bannerEndPoint
        val posterUrl: String = IMAGE_PATH_URL + posterEndPoint

        movieDetail = MovieDetail(movieId, title, overView, releaseDate, posterUrl, bannerUrl, budget, revenue, runtime)

    } catch (e: JSONException) {
        Log.error("Problem parsing the Selected Movie JSON results $e")
    }

    // Create a new {@link MovieDetail} object with required properties
    return movieDetail
}