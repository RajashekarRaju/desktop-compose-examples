package movieApiExample.network

// https://api.themoviedb.org/3/movie/popular?api_key=
// https://api.themoviedb.org/3/movie/454292/similar?api_key=
// https://api.themoviedb.org/3/search/movie?api_key=&query=salt
// https://api.themoviedb.org/3/movie/454292/credits?api_key=

const val APPEND_QUERY_PARAMETER = "="
private const val API_PARAM = "api_key"
const val APPEND_URL_ENDPOINT = "?"
const val APPEND_PARAMETER = "&"
const val QUERY_PARAM = "query"
const val PATH = "/"
const val assignApiKey = API_PARAM + APPEND_QUERY_PARAMETER + API_KEY

private const val SCHEME_AUTHORITY = "https://api.themoviedb.org/"
private const val APPEND_PATH_VERSION = "3/"
const val APPEND_PATH_MOVIE = "movie"
const val BASE_PATH = SCHEME_AUTHORITY + APPEND_PATH_VERSION
const val MOVIE_PATH = SCHEME_AUTHORITY + APPEND_PATH_VERSION + APPEND_PATH_MOVIE + PATH

private const val APPEND_PATH_SEARCH = "search/"
const val SEARCH_BASE_PATH = "$BASE_PATH$APPEND_PATH_SEARCH$APPEND_PATH_MOVIE$APPEND_URL_ENDPOINT"

const val TYPE_MOVIES_POPULAR = "popular"
const val TYPE_MOVIES_TOP_RATED = "top_rated"
const val TYPE_MOVIES_UPCOMING = "upcoming"
const val TYPE_MOVIES_NOW_PLAYING = "now_playing"
// const val TYPE_MOVIES_LATEST = "latest"

const val APPEND_PATH_SIMILAR = "similar"
const val APPEND_PATH_RECOMMENDATIONS = "recommendations"

// private const val APPEND_PATH_PERSON = "person"
// private const val REVIEWS_PATH = "reviews"
const val APPEND_PATH_CREDITS = "credits"

const val IMAGE_PATH_URL = "https://image.tmdb.org/t/p/w500"
const val IMAGE_PATH_BANNER_URL = "https://image.tmdb.org/t/p/original"