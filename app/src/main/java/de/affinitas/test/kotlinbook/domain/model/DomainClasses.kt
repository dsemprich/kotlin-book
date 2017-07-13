package de.affinitas.test.kotlinbook.domain.model

data class Forecast(val date: String, val description: String, val high: Int, val low: Int, val iconUrl: String)

data class ForecastList(val city: String, val country: String, val dailyForecast: List<Forecast>){

    operator fun get(position: Int) = dailyForecast[position]
    val size : Int = dailyForecast.size
}