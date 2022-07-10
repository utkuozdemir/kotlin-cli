package org.utkuozdemir.command

import com.github.ajalt.clikt.core.CliktCommand

private const val AGE_BEFORE = 42
private const val AGE_AFTER = 52

class DataClass : CliktCommand() {
    override fun run() {
        val person1 = Person("Faik", AGE_BEFORE)
        println(person1)
        val person2 = person1.copy(age = AGE_AFTER)
        println(person2)
    }
}

data class Person(val name: String, val age: Int)
