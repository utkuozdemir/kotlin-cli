package org.utkuozdemir.command

import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.parameters.options.default
import com.github.ajalt.clikt.parameters.options.option
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

class NetworkIo : CliktCommand("does network IO") {
    private val client: HttpClient = HttpClient.newHttpClient()

    private val defaultUrl = "https://google.com"

    private val url by option(help = "The URL to make request to $defaultUrl").default(defaultUrl)

    override fun run() {
        println("Request to $url")
        val request = HttpRequest.newBuilder()
            .uri(URI.create(url))
            .build()

        val response = client.send(request, HttpResponse.BodyHandlers.ofString())

        println("Response:")
        println(response.body())
    }
}
