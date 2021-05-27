package catsOfClaire.ui.cats

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.unit.dp
import catsOfClaire.model.Cats
import catsOfClaire.data.PuppyAdoptionRepo
import catsOfClaire.gradientWidth
import catsOfClaire.offsetGradientBackground
import catsOfClaire.ui.theme.CatCompanionColor

// Start of the CatsList UI
@ExperimentalAnimationApi
@Composable
fun catsList() {
    Scaffold(
        topBar = {
            Text(
                text = "Cats",
                style = MaterialTheme.typography.h3,
                modifier = Modifier.padding(16.dp)
            )
        }
    ) {
        catsListBody()
    }
}

// Start of List
@ExperimentalAnimationApi
@Composable
private fun catsListBody() {
    // Save the scroll state of cats list
    val scrollState = rememberLazyListState()
    val cats: List<Cats> = PuppyAdoptionRepo.getCatsList()

    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(20.dp),
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize()
            .scrollable(state = scrollState, orientation = Orientation.Horizontal, enabled = true),
        verticalAlignment = Alignment.CenterVertically
    ) {
        items(cats) { cat ->
            catRow(cat)
        }
    }
}

// Item row for one cat.
@ExperimentalAnimationApi
@Composable
private fun catRow(
    cat: Cats
) {
    Card(
        Modifier.fillMaxWidth().clickable { },
        shape = MaterialTheme.shapes.large
    ) {
        val colorList = listOf(cat.catHairColor, CatCompanionColor)

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .offsetGradientBackground(colorList, gradientWidth)
                .padding(24.dp),
            verticalArrangement = Arrangement.Center
        ) {

            AnimatedVisibility(
                initiallyVisible = false, visible = true
            ) {
                Image(
                    bitmap = imageResource(cat.catImage),
                    contentDescription = "Image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(240.dp)
                        .clip(CircleShape)
                        .border(2.dp, Color.Gray, CircleShape),
                )
            }

            Spacer(Modifier.height(24.dp))

            Text(
                text = cat.catName,
                style = MaterialTheme.typography.h4,
                color = Color.Gray
            )
        }
    }
}