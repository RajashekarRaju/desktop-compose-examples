package musicSearch.data

import musicSearch.model.Songs

object MusicRepo {

    fun getMusicData() = listOf(
        Songs(1, "covers/textbook.jpeg", "Text Book", "Lana Del Rey", "Blue Banisters", "5:03", true),
        Songs(2, "covers/someone_like_you.jpeg", "Someone Like You", "Adele", "21", "4:45", true),
        Songs(3, "covers/yosemite.jpeg", "Yosemite", "Lana Del Rey", "Chemtrails Over The Country Club", "5:06", true),
        Songs(4, "covers/blue_kentucky_girl.jpeg", "Blue Kentucky Girl", "Loretta Lynn", "Blue Kentucky Girl", "2:43", false),
        Songs(5, "covers/1989.jpeg", "Wildest Dreams", "Taylor Swift", "1989", "3:40", false),
        Songs(6, "covers/summer_depression.jpeg", "Summer Depression", "Girl in Red", "Summer Depression", "2:31", true),
        Songs(7, "covers/positions.jpeg", "Shut up", "Ariana Grande", "Positions", "2:37", false),
        Songs(8, "covers/love_on_the_brain.jpeg", "Love On The Brain", "Rihanna", "ANTI", "3:44", true),
        Songs(9, "covers/the_end_of_the_world.jpeg", "The End Of The World", "Skeeter Davis", "The Essential Skeeter Davis", "2:37", true),
        Songs(10, "covers/brighton_rock.jpeg", "Brighton Rock", "Queen", "Sheer Heart Attack", "5:10", true),
        Songs(11, "covers/photograph.jpeg", "Photograph", "Ed Sheeran", "X", "4:18", false),
        Songs(12, "covers/depression_cherry.jpeg", "Space Song", "Beach House", "Depression Cherry", "5:20", true),
    )
}