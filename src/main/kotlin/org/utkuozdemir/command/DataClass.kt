package org.utkuozdemir.command

import com.github.ajalt.clikt.core.CliktCommand

class DataClass : CliktCommand() {
    override fun run() {
        val person1 = Person("Faik", 42)
        println(person1)
        val person2 = person1.copy(age = 52)
        println(person2)
    }
}

data class Person(val name: String, val age: Int)
