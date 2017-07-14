package de.affinitas.test.kotlinbook.domain.datasource

import de.affinitas.test.kotlinbook.domain.model.Forecast
import de.affinitas.test.kotlinbook.domain.model.ForecastList

interface ForecastDataSource {

    fun requestForecastByZipCode(zipCode: Long, date: Long): ForecastList?

    fun requestDayForecast(id: Long): Forecast?

}