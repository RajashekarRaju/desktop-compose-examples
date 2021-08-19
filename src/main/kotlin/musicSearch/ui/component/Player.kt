package musicSearch.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Slider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp


@Composable
fun player() {

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxSize()
    ) {

        Row(
            modifier = Modifier.fillMaxHeight().weight(3f)
        ) {
            Image(
                painter = painterResource("covers/yosemite.jpeg"),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(60.dp),
            )

            Column(
                modifier = Modifier.width(240.dp).padding(8.dp).weight(3f)
            ) {
                Text(
                    text = "Yosemite",
                    modifier = Modifier.padding(horizontal = 8.dp),
                    style = MaterialTheme.typography.subtitle1
                )

                Spacer(modifier = Modifier.padding(vertical = 2.dp))

                Text(
                    text = "Lana Del Rey",
                    modifier = Modifier.padding(horizontal = 8.dp),
                    style = MaterialTheme.typography.caption
                )
            }
        }

        var duration by rememberSaveable { mutableStateOf(4f) }
        var volume by rememberSaveable { mutableStateOf(6f) }

        Column(
            modifier = Modifier.weight(4f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {

                Image(
                    painter = painterResource("shuffle.svg"),
                    contentDescription = null,
                    modifier = Modifier.padding(horizontal = 16.dp).size(20.dp),
                )

                Image(
                    painter = painterResource("skip_previous.svg"),
                    contentDescription = null,
                    modifier = Modifier.padding(horizontal = 12.dp).size(24.dp),
                )

                Image(
                    painter = painterResource("play_circle_filled.svg"),
                    contentDescription = null,
                    modifier = Modifier.size(48.dp),
                )

                Image(
                    painter = painterResource("skip_next.svg"),
                    contentDescription = null,
                    modifier = Modifier.padding(horizontal = 12.dp).size(24.dp),
                )

                Image(
                    painter = painterResource("repeat.svg"),
                    contentDescription = null,
                    modifier = Modifier.padding(horizontal = 16.dp).size(20.dp),
                )
            }

            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {

                Text(
                    text = "0:00",
                    modifier = Modifier.weight(1f),
                    style = MaterialTheme.typography.overline,
                    color = Color.White,
                    textAlign = TextAlign.End
                )

                Slider(
                    value = duration,
                    onValueChange = { duration = it },
                    enabled = true,
                    valueRange = 1f..10f,
                    modifier = Modifier.weight(8f),
                )

                Text(
                    text = "5:10",
                    modifier = Modifier.weight(1f),
                    style = MaterialTheme.typography.overline,
                    color = Color.White,
                    textAlign = TextAlign.Start
                )
            }
        }

        Row(
            modifier = Modifier.padding(end = 16.dp).fillMaxHeight().weight(3f),
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Image(
                painter = painterResource("queue.svg"),
                contentDescription = null,
                modifier = Modifier.padding(horizontal = 8.dp).size(20.dp),
            )

            Image(
                painter = painterResource("devices.svg"),
                contentDescription = null,
                modifier = Modifier.padding(horizontal = 8.dp).size(20.dp),
            )

            Image(
                painter = painterResource("volume_up.svg"),
                contentDescription = null,
                modifier = Modifier.padding(horizontal = 8.dp).size(20.dp),
            )

            Slider(
                value = volume,
                onValueChange = { volume = it },
                enabled = true,
                modifier = Modifier.width(120.dp),
                valueRange = 1f..10f,
            )
        }
    }
}