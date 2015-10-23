package com.pratamawijaya.basickotlin.ui.adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.widget.TextView

/**
 * Created by : pratama - set.mnemonix@gmail.com
 * Date : 10/24/15
 * Project : BasicKotlin
 */
public class WeatherAdapter(val items: List<String>) : RecyclerView.Adapter<WeatherAdapter.RecylerViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecylerViewHolder? {
        return RecylerViewHolder(TextView(parent.context))
    }

    override fun onBindViewHolder(holder: RecylerViewHolder, position: Int) {
        holder.textView.text = items.get(position)
    }

    override fun getItemCount(): Int = items.size

    class RecylerViewHolder(val textView: TextView) : RecyclerView.ViewHolder(textView)
}
