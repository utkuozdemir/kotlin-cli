package org.utkuozdemir.command

import com.github.ajalt.clikt.core.CliktCommand
import java.nio.file.Files

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
