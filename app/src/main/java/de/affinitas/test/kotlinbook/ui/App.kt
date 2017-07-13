package de.affinitas.test.kotlinbook.ui

import android.app.Application
import android.database.sqlite.SQLiteOpenHelper
import de.affinitas.test.kotlinbook.extensions.DelegatesExt

class App : Application() {

    companion object {
        var instance: App by DelegatesExt.notNullSingleValue()
    }

    val database: SQLiteOpenHelper by lazy {
        MyDatabaseHelper(applicationContext)
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        val db = database.writableDatabase
    }
}