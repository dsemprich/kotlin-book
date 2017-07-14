package de.affinitas.test.kotlinbook.domain.datasource

import de.affinitas.test.kotlinbook.data.db.ForecastDb
import de.affinitas.test.kotlinbook.data.server.ForecastServer
import de.affinitas.test.kotlinbook.domain.model.Forecast
import de.affinitas.test.kotlinbook.domain.model.ForecastList
import de.affinitas.test.kotlinbook.extensions.firstResult

class ForecastProvider(val sources: List<ForecastDataSource> = ForecastProvider.SOURCES) {

    companion object {
        val DAY_IN_MILLIS = 1000 * 60 * 60 * 24
        val SOURCES by lazy { listOf(ForecastDb(), ForecastServer()) }
    }

    fun requestByZipCode(zipCode: Long, days: Int): ForecastList = requestToSources {
        val res = it.requestForecastByZipCode(zipCode, todayTimeSpan())
        if (res != null && res.size >= days) res else null
    }

    fun requestForecast(id: Long): Forecast = requestToSources { it.requestDayForecast(id) }

    private fun todayTimeSpan() = System.currentTimeMillis() / DAY_IN_MILLIS * DAY_IN_MILLIS

    private fun <T : Any> requestToSources(
            f: (ForecastDataSource) -> T?): T = sources.firstResult { f(it) }

}