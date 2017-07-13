package de.affinitas.test.kotlinbook

import android.util.Log
import java.net.URL

class Person {
    // uses default getter and setter
    //var name : String = ""

    //custom
    var name = ""
        get() = field.toUpperCase()
        set(value) { field = "Name: $value" }
}

class Request(val url: String) {
    fun run() {
        val forecastJsonStr = URL(url).readText()
        Log.d(javaClass.simpleName, forecastJsonStr)
    }
}