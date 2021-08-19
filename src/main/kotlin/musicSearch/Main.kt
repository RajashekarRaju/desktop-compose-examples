package musicSearch

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import musicSearch.theme.musicSearchDesktopTheme
import musicSearch.ui.musicMainComponent

fun main() = application {

    Window(
        onCloseRequest = ::exitApplication,
        title = "Compose Music App"
    ) {

        musicSearchDesktopTheme(true) {
            Surface(modifier = Modifier.fillMaxSize()) {
                musicMainComponent()
            }
        }
    }
}