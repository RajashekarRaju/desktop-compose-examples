package movieApiExample.network

import movieApiExample.model.Movie
import org.jetbrains.skija.impl.Log
import org.json.JSONException
import org.json.JSONObject

private const val IMAGE_PATH_URL = "https://image.tmdb.org/t/p/w500"

/**
 * Return a list of [Movie] objects that has been built up from parsing a JSON response.
 */
fun getJsonMovieData(newJSON: String?): List<Movie> {

    val movieData: MutableList<Movie> = ArrayList()

    try {
        // Create a JSONObject from the JSON response string
        val baseJsonResponse = JSONObject(newJSON)
        // Extract the JSONArray associated with the key called "results",
        // which represents a list of features (or new).
        val newArray = baseJsonResponse.getJSONArray("results")
        for (i in 0 until newArray.length()) {

            // Create a JSONObject from the JSON response string
            val jsonObject = newArray.getJSONObject(i)

            val title: String? = jsonObject.getString("original_title")
            val overView: String? = jsonObject.getString("overview")
            val releaseDate: String? = jsonObject.getString("release_date")

            val bannerEndPoint: String? = jsonObject.getString("backdrop_path")
            val bannerUrl: String = IMAGE_PATH_URL + bannerEndPoint

            // Create a new {@link Movie} object with required properties
            val newFinal = Movie(title, overView, releaseDate, bannerUrl)

            // Add the new {@link Movie} to the list of movies.
            movieData.add(newFinal)
        }
    } catch (e: JSONException) {
        Log.error("Problem parsing the JSON results $e")
    }
    // Return the list of Movies
    return movieData
}