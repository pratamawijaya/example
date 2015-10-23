package com.pratamawijaya.basickotlin.data.network

import android.util.Log
import java.net.URL

/**
 * Created by : pratama - set.mnemonix@gmail.com
 * Date : 10/24/15
 * Project : BasicKotlin
 */
public class Request(val url: String) {
    public fun run() {
        val foreCastJsonStr = URL(url).readText()
        Log.d(javaClass.simpleName, foreCastJsonStr)
    }
}