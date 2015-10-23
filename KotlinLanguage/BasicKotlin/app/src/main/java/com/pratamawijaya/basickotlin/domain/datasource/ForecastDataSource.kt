package com.pratamawijaya.basickotlin.domain.datasource

import com.pratamawijaya.basickotlin.domain.model.Forecast
import com.pratamawijaya.basickotlin.domain.model.ForecastList

/**
 * Created by : pratama - set.mnemonix@gmail.com
 * Date : 10/24/15
 * Project : BasicKotlin
 */
interface ForecastDataSource {
    fun requestForecastByZipCode(zipCode: Long, date: Long): ForecastList?

    fun requestDayForecast(id: Long): Forecast?
}