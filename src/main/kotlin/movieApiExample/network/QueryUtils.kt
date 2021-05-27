package movieApiExample.network

import org.jetbrains.skija.impl.Log
import java.net.HttpURLConnection
import java.net.MalformedURLException
import java.net.URL
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import org.jetbrains.skija.Image
import java.io.*
import java.util.*
import javax.imageio.ImageIO
import javax.net.ssl.HttpsURLConnection


fun getResponseFromHttpUrl(requestUrl: URL?): String {

    val httpsURLConnection: HttpsURLConnection = requestUrl?.openConnection() as HttpsURLConnection
    var response = ""

    try {
        val inputStream = httpsURLConnection.inputStream
        val scanner = Scanner(inputStream)
        scanner.useDelimiter("\\A")
        if (scanner.hasNext()) {
            response = scanner.next()
        }
        scanner.close()
    } catch (e: Exception) {
        println(e)
    } finally {
        httpsURLConnection.disconnect()
    }

    return response
}

fun createUrl(stringUrl: String): String {
    var url: URL? = null
    try {
        url = URL(stringUrl)
    } catch (e: MalformedURLException) {
        Log.error("Problem building the URL - $e")
    }
    return getResponseFromHttpUrl(url)
}

fun loadNetworkImage(link: String?): ImageBitmap {
    val url = URL(link)
    val connection = url.openConnection() as HttpURLConnection
    connection.connect()

    val inputStream = connection.inputStream
    val bufferedImage = ImageIO.read(inputStream)

    val stream = ByteArrayOutputStream()
    ImageIO.write(bufferedImage, "png", stream)
    val byteArray = stream.toByteArray()

    return Image.makeFromEncoded(byteArray).asImageBitmap()
}
