package org.utkuozdemir

import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.core.subcommands
import com.github.ajalt.clikt.parameters.options.default
import com.github.ajalt.clikt.parameters.options.option
import java.nio.file.Files

fun main(args: Array<String>) = KotlinCli().subcommands(FileIo(), NetworkIo()).main(args)


class KotlinCli : CliktCommand() {
    override fun run() {
    }
}

class FileIo : CliktCommand() {
    override fun run() {
        val tempFile = Files.createTempFile("kotlin-cli", ".txt")
        println("Created temp file $tempFile")
        try {
            Files.write(tempFile, "hello file!".toByteArray())
            println("Wrote to file")
            val fileContent = Files.readAllBytes(tempFile).decodeToString()
            println("Read from file: $fileContent")

        } finally {
            Files.delete(tempFile)
            println("Deleted file $tempFile")
        }
    }
}

class NetworkIo : CliktCommand("does network IO") {
    private val defaultUrl = "https://google.com"

    val url by option(help = "The URL to make request to $defaultUrl").default(defaultUrl)

    override fun run() {
        println("Request to $url")
    }
}
