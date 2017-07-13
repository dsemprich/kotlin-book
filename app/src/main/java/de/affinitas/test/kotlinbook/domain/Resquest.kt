package de.affinitas.test.kotlinbook.domain

import android.util.Log
import com.google.gson.Gson
import de.affinitas.test.kotlinbook.data.server.ForecastResult
import de.affinitas.test.kotlinbook.domain.model.Forecast as ModelForecast

class ForecastRequest(val zipCode: String) {
    companion object {
        private val APP_ID = "bd5e378503939ddaee76f12ad7a97608"
        private val URL = "http://api.openweathermap.org/data/2.5/" +
                "forecast/daily?mode=json&units=metric&cnt=7"
        private val COMPLETE_URL = "$URL&APPID=$APP_ID&q="
    }

    fun execute() : ForecastResult {
        val forecastJsonStr = java.net.URL(COMPLETE_URL + zipCode).readText()
        Log.d(javaClass.simpleName, forecastJsonStr)
        return Gson().fromJson(forecastJsonStr, ForecastResult::class.java)
    }
}