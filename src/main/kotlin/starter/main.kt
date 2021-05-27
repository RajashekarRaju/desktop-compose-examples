package starter

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.desktop.Window
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.unit.dp


@ExperimentalAnimationApi
fun main() {

    Window {

        Card {
            var expanded by remember { mutableStateOf(false) }
            Column(
                modifier = Modifier.clickable { expanded = !expanded }
            ) {
                Image(
                    modifier = Modifier.size(300.dp, 300.dp),
                    bitmap = imageResource("catImages/item_image_chuchu.jpg"),
                    contentDescription = "",
                    contentScale = ContentScale.Crop
                )
                AnimatedVisibility(expanded) {
                    Text(
                        text = "ChuChu",
                        style = MaterialTheme.typography.h2
                    )
                }
            }
        }
    }
}