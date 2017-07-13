package de.affinitas.test.kotlinbook.domain.commands

interface Command<out T> {
    fun execute() : T
}