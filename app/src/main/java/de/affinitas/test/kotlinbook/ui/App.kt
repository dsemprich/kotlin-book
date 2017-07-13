package de.affinitas.test.kotlinbook.ui

import android.app.Application
import de.affinitas.test.kotlinbook.extensions.DelegatesExt

class App : Application() {

    companion object {
        var instance: App by DelegatesExt.notNullSingleValue()
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}