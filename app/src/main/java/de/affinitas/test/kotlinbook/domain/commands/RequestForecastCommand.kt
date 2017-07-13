package de.affinitas.test.kotlinbook.domain.commands

import de.affinitas.test.kotlinbook.data.server.ForecastDataMapper
import de.affinitas.test.kotlinbook.domain.ForecastRequest
import de.affinitas.test.kotlinbook.domain.model.ForecastList

class RequestForecastCommand(val zipCode: String) : Command<ForecastList> {
    override fun execute(): ForecastList {
        val forecastRequest = ForecastRequest(zipCode)
        return ForecastDataMapper().convertFromDataModel(forecastRequest.execute())
    }
}