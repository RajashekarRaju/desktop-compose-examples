package musicSearch.model

data class Songs(
    val id: Int,
    val cover: String,
    val title: String,
    val artist: String,
    val album: String,
    val duration: String,
    val isFavorite: Boolean
)