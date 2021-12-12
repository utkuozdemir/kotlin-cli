package org.utkuozdemir

import java.nio.file.Files

fun main() {
    println("Hello, World")

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
