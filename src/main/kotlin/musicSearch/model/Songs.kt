package musicSearch.model

data class Songs(
    val id: Int,
    val title: String,
    val artist: String
) {
    companion object {
        val listData = listOf(
            Songs(1,"Text Book", "Lana Del Rey"),
            Songs(2,"Someone Like You", "Adele"),
            Songs(3,"Photograph", "Ed Sheeran"),
            Songs(4,"Blue Kentucky Girl", "Loretta Lynn"),
            Songs(5,"Summer Depression", "Girl in Red"),
            Songs(6,"Positions", "Ariana Grande"),
            Songs(7,"Love On The Brain", "Rihanna"),
            Songs(8,"The End Of The World", "Skeeter Davis"),
            Songs(9,"Brighton Rock", "Queen"),
            Songs(10,"Yosemite", "Lana Del Rey")
        )
    }
}
