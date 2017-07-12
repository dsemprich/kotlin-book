package de.affinitas.test.kotlinbook

class Person {
    // uses default getter and setter
    //var name : String = ""

    //custom
    var name = ""
        get() = field.toUpperCase()
        set(value) { field = "Name: $value" }
}