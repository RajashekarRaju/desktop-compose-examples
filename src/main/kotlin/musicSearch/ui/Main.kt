package musicSearch.ui

import androidx.compose.desktop.Window
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import musicSearch.theme.musicSearchDesktopTheme

@ExperimentalStdlibApi
fun main() = Window {

    musicSearchDesktopTheme(true) {
        Surface(modifier = Modifier.fillMaxSize()) {
            musicList()
        }
    }
}