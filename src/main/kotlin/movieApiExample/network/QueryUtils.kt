package movieApiExample.network

import org.jetbrains.skija.impl.Log
import java.net.MalformedURLException
import java.net.URL
import java.util.*
import javax.net.ssl.HttpsURLConnection


fun createUrl(
    requestUrl: URL
): String {
    var url: URL? = null
    try {
        url = URL(requestUrl.toString())
    } catch (e: MalformedURLException) {
        Log.error("Problem building the URL - $e")
    }
    return getResponseFromHttpUrl(url)
}

fun getResponseFromHttpUrl(
    requestUrl: URL?
): String {

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
