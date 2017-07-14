package de.affinitas.test.kotlinbook.domain.commands

import de.affinitas.test.kotlinbook.domain.datasource.ForecastProvider
import de.affinitas.test.kotlinbook.domain.model.ForecastList

class RequestForecastCommand(
        val zipCode: Long, val forecastProvider: ForecastProvider = ForecastProvider()) : Command<ForecastList> {

    companion object {
        val DAYS = 7
    }

    override fun execute() = forecastProvider.requestByZipCode(zipCode, DAYS)
}