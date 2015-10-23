package com.pratamawijaya.basickotlin.data.network

import com.google.gson.Gson
import com.pratamawijaya.basickotlin.data.model.ForecastResult
import java.net.URL

/**
 * Created by : pratama - set.mnemonix@gmail.com
 * Date : 10/24/15
 * Project : BasicKotlin
 */
public class ForecastRequest(val zipCode: String) {
    companion object {
        private val URL = "http://api.openweathermap.org/data/2.5/" +
                "forecast/daily?mode=json&units=metric&cnt=7&q="
    }

    public fun execute(): ForecastResult {
        val forecastJsonStr = URL(URL + zipCode).readText();
        return Gson().fromJson(forecastJsonStr, ForecastResult::class.java)
    }
}
