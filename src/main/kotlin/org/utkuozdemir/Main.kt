package org.utkuozdemir

import com.github.ajalt.clikt.core.subcommands
import org.utkuozdemir.command.DataClass
import org.utkuozdemir.command.FileIo
import org.utkuozdemir.command.KotlinCli
import org.utkuozdemir.command.NetworkIo

fun main(args: Array<String>) =
    KotlinCli().subcommands(
        FileIo(),
        NetworkIo(),
        DataClass()
    ).main(args)
