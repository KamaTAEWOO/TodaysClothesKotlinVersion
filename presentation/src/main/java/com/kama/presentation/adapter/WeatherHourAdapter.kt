package com.kama.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kama.presentation.R
import com.kama.presentation.data.WeatherHourData

class WeatherHourAdapter(private val weatherList: MutableList<WeatherHourData>) : RecyclerView.Adapter<WeatherHourAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_hour_weather, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(weatherList)
    }

    override fun getItemCount(): Int {
        return weatherList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val time: TextView = itemView.findViewById(R.id.tv_time)
        private val temp: TextView = itemView.findViewById(R.id.tv_temp)

        fun bind(data: MutableList<WeatherHourData>) {
            time.text = data.get(adapterPosition).time
            temp.text = data.get(adapterPosition).temperature
        }
    }
}