package com.pratamawijaya.basickotlin.domain.model

/**
 * Created by : pratama - set.mnemonix@gmail.com
 * Date : 10/24/15
 * Project : BasicKotlin
 */
data class ForecastList(val id: Long, val city: String, val country: String, val dailyForecast: List<Forecast>)

data class Forecast(val id: Long, val date: Long, val description: String, val high: Int, val low: Int, val iconUrl: String)