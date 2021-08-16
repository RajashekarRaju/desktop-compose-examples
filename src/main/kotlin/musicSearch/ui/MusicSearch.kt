package musicSearch.ui

import musicSearch.model.Songs
import musicSearch.model.Songs.Companion.listData
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@ExperimentalStdlibApi
@Composable
fun musicList() {

    var searchQuery by rememberSaveable { mutableStateOf("") }

    Column(modifier = Modifier.fillMaxSize().padding(8.dp)) {

        Spacer(modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(
                text = "Search",
                modifier = Modifier.padding(horizontal = 8.dp),
                style = MaterialTheme.typography.h5
            )

            Spacer(modifier = Modifier.padding(horizontal = 8.dp))

            Box(
                modifier = Modifier.width(width = 240.dp).height(32.dp)
            ) {

                Row(
                    modifier = Modifier.fillMaxSize()
                        .clip(RoundedCornerShape(40.dp))
                        .background(color = Color.White)
                ) {

                    Spacer(modifier = Modifier.padding(horizontal = 4.dp))

                    Icon(
                        modifier = Modifier.align(alignment = Alignment.CenterVertically),
                        imageVector = Icons.Default.Search,
                        contentDescription = "Search Icon",
                        tint = Color.Gray
                    )

                    BasicTextField(
                        value = searchQuery,
                        onValueChange = { newQuery ->
                            searchQuery = newQuery
                        },
                        textStyle = MaterialTheme.typography.subtitle1,
                        singleLine = true,
                        maxLines = 1,
                        modifier = Modifier.wrapContentSize()
                            .padding(start = 8.dp, end = 8.dp, bottom = 4.dp)
                            .align(alignment = Alignment.CenterVertically)
                    )
                }

                if (searchQuery.isEmpty()) {
                    showSearchHint()
                }
            }
        }

        Spacer(modifier = Modifier.fillMaxWidth().padding(vertical = 16.dp))

        Text(
            text = "Your Library",
            modifier = Modifier.padding(horizontal = 8.dp),
            style = MaterialTheme.typography.h4
        )

        Spacer(modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp))

        performFilterWithQuery(searchQuery)
    }
}

@Composable
fun showSearchHint() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize()
    ) {

        Text(
            text = "Search Song Name",
            color = Color.Gray,
            modifier = Modifier.wrapContentSize()
                .padding(start = 4.dp, end = 4.dp, bottom = 4.dp)
                .align(alignment = Alignment.CenterVertically)
        )
    }
}

@ExperimentalStdlibApi
@Composable
fun performFilterWithQuery(searchQuery: String) {

    if (searchQuery.isNotEmpty()) {
        val filteredSongs = ArrayList<Songs>()
        for (song in listData) {
            if (song.title.lowercase().contains(searchQuery.lowercase())) {
                filteredSongs.add(song)
            }
        }
        displaySongs(filteredSongs)
    } else {
        displaySongs(listData)
    }
}

@Composable
fun displaySongs(songs: List<Songs>) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(4.dp),
        modifier = Modifier.fillMaxWidth()
    ) {

        items(songs) { song ->

            Row(modifier = Modifier.fillMaxWidth().padding(16.dp)) {

                Text(text = song.id.toString(), modifier = Modifier.padding(horizontal = 12.dp))

                Text(
                    text = song.title,
                    modifier = Modifier.padding(horizontal = 16.dp).width(240.dp)
                )

                Text(
                    text = song.artist,
                    modifier = Modifier.padding(horizontal = 16.dp).width(200.dp)
                )
            }
        }
    }
}