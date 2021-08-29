package musicSearch.ui

import androidx.compose.foundation.Image
import musicSearch.model.Songs
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.input.pointer.pointerMoveFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import musicSearch.data.MusicRepo
import musicSearch.ui.component.player
import musicSearch.ui.component.searchContainer


@Composable
fun musicMainComponent() {

    var searchQuery by rememberSaveable { mutableStateOf("") }

    Column(modifier = Modifier.fillMaxSize()) {

        Spacer(modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp))

        searchQuery = searchContainer(searchQuery)

        Spacer(modifier = Modifier.fillMaxWidth().padding(vertical = 12.dp))

        Column(modifier = Modifier.fillMaxWidth().weight(8.5f)) {
            performFilterWithQuery(searchQuery)
        }

        Column(
            modifier = Modifier.fillMaxWidth()
                .weight(1.5f)
                .background(color = Color(0xFF181818))
                .padding(20.dp)
        ) {
            player()
        }
    }
}

@Composable
fun performFilterWithQuery(searchQuery: String) {

    val musicList = MusicRepo.getMusicData()

    if (searchQuery.isNotEmpty()) {
        val filteredSongs = ArrayList<Songs>()
        for (song in musicList) {
            if (song.title.lowercase().contains(searchQuery.lowercase())) {
                filteredSongs.add(song)
            }
        }
        displaySongs(filteredSongs)
    } else {
        displaySongs(musicList)
    }
}

@Composable
fun displaySongs(songs: List<Songs>) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(4.dp),
        modifier = Modifier.fillMaxWidth()
    ) {

        items(songs) { song ->

            var color by rememberSaveable { mutableStateOf(Color.Transparent) }
            var playIconState by remember { mutableStateOf(false) }

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
                    .clip(RoundedCornerShape(44.dp))
                    .padding(horizontal = 16.dp, vertical = 4.dp)
                    .background(color = color)
                    .pointerMoveFilter(
                        onMove = {
                            color = Color(0xFF202020)
                            false
                        },
                        onEnter = {
                            playIconState = !playIconState
                            color = Color.Transparent
                            false
                        },
                        onExit = {
                            playIconState = !playIconState
                            color = Color.Transparent
                            false
                        },
                    )
            ) {

                if (!playIconState) {
                    Text(
                        text = song.id.toString(),
                        modifier = Modifier.padding(start = 8.dp, end = 16.dp).width(20.dp),
                        textAlign = TextAlign.End
                    )
                } else {
                    Image(
                        imageVector = Icons.Rounded.PlayArrow,
                        contentDescription = null,
                        modifier = Modifier.padding(horizontal = 16.dp).size(32.dp),
                        colorFilter = ColorFilter.tint(Color(0xFF1db954))
                    )
                }

                Image(
                    painter = painterResource(song.cover),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.size(48.dp),
                )

                Column(
                    modifier = Modifier.width(280.dp).padding(8.dp).weight(3f)
                ) {
                    Text(
                        text = song.title,
                        modifier = Modifier.padding(horizontal = 8.dp),
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.padding(vertical = 2.dp))

                    Text(
                        text = song.artist,
                        modifier = Modifier.padding(horizontal = 8.dp)
                    )
                }

                Text(
                    text = song.album,
                    modifier = Modifier.width(280.dp)
                        .padding(horizontal = 8.dp)
                        .weight(3f),
                    textAlign = TextAlign.Start
                )

                Image(
                    imageVector = getFavoriteState(song.isFavorite),
                    colorFilter = ColorFilter.tint(color = Color(0xFF1db954)),
                    contentDescription = null,
                    modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 4.dp).size(20.dp)
                )

                Text(
                    text = song.duration,
                    modifier = Modifier.padding(start = 8.dp, end = 20.dp)
                        .weight(1f)
                        .align(Alignment.CenterVertically),
                    textAlign = TextAlign.Start
                )

                if (playIconState) {
                    Image(
                        imageVector = Icons.Rounded.MoreVert,
                        contentDescription = null,
                        modifier = Modifier.padding(horizontal = 16.dp).size(32.dp),
                        colorFilter = ColorFilter.tint(Color(0xFF1db954))
                    )
                }
            }
        }
    }
}

fun getFavoriteState(
    isFavorite: Boolean
): ImageVector {
    return when {
        isFavorite -> Icons.Rounded.Favorite
        else -> Icons.Rounded.FavoriteBorder
    }
}