package movieApiExample

import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import org.jetbrains.skija.Image
import java.io.ByteArrayOutputStream
import java.net.HttpURLConnection
import java.net.URL
import javax.imageio.ImageIO


fun loadNetworkImage(
    link: String?
): ImageBitmap {
    val url = URL(link)
    val connection = url.openConnection() as HttpURLConnection
    connection.connect()

    val inputStream = connection.inputStream
    val bufferedImage = ImageIO.read(inputStream)

    val stream = ByteArrayOutputStream()
    ImageIO.write(bufferedImage, "jpg", stream)
    val byteArray = stream.toByteArray()

    return Image.makeFromEncoded(byteArray).asImageBitmap()
}

fun minutesToHours(time: Int): String {
    val hours: Int = time / 60
    val minutes: Int = time % 60
    return "$hours h : $minutes m"
}

// Answer from StackOverflow
fun truncateNumber(floatNumber: Long?): String {
    val million = 1000000L
    val billion = 1000000000L
    val trillion = 1000000000000L
    if (floatNumber in million until billion) {
        val fraction = calculateFraction(floatNumber, million)
        return "$ $fraction million"
    } else if (floatNumber in billion until trillion) {
        val fraction = calculateFraction(floatNumber, billion)
        return "$ $fraction billion"
    }
    return floatNumber.toString()
}

// Answer from StackOverflow
fun calculateFraction(number: Long?, divisor: Long): Float {
    val truncate = (number!! * 10L + divisor / 2L) / divisor
    return truncate.toFloat() * 0.10f
}