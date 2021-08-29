package musicSearch.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable
fun searchContainer(searchQuery: String): String {

    var searchQuery1 = searchQuery

    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
    ) {

        Text(
            text = "Your Library",
            modifier = Modifier.padding(horizontal = 8.dp),
            style = MaterialTheme.typography.h5
        )

        Spacer(modifier = Modifier.padding(horizontal = 8.dp))

        Box(
            modifier = Modifier.width(width = 280.dp).height(36.dp)
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

                Box(
                    modifier = Modifier.wrapContentSize()
                        .align(alignment = Alignment.CenterVertically)
                        .padding(start = 8.dp, end = 8.dp, bottom = 4.dp),
                ) {
                    BasicTextField(
                        value = searchQuery1,
                        onValueChange = { searchQuery1 = it },
                        textStyle = MaterialTheme.typography.subtitle1,
                        singleLine = true,
                        maxLines = 1,
                        modifier = Modifier.wrapContentSize()
                    )

                    if (searchQuery1.isEmpty()) {
                        Text(text = "Search Song Name", color = Color.Gray)
                    }
                }
            }
        }
    }

    return searchQuery1
}