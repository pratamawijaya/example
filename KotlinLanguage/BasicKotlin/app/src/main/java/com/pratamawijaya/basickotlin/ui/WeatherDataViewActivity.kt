package com.pratamawijaya.basickotlin.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.pratamawijaya.basickotlin.R
import com.pratamawijaya.basickotlin.ui.adapter.WeatherAdapter
import com.pratamawijaya.basickotlin.data.network.Request
import org.jetbrains.anko.*
import java.util.concurrent.Executors

class WeatherDataViewActivity : AppCompatActivity() {

    private val items = listOf(
            "Raisya",
            "Isyana",
            "Chelsea Islan",
            "Pevita"
    )

    private val WEBSERVICE_URL: String = "http://"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)

        //        val recyclerView = findViewById(R.id.recycler_view) as RecyclerView
        val recyclerView: RecyclerView = find(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = WeatherAdapter(items)

        toast("finished load list")
        longToast("finish load list : text dowo")

        val executor = Executors.newScheduledThreadPool(4)
        async(executor) {
            Request(WEBSERVICE_URL).run()
            uiThread { longToast("Request perform") }
        }
    }

}
