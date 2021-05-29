package movieApiExample.model

data class MovieDetail(
    val movieId: Int,
    val title: String?,
    val overView: String?,
    val releaseDate: String?,
    val posterUrl: String?,
    val bannerUrl: String?
)
