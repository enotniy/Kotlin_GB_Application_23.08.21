package com.kotlin.gbapplication2308

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kotlin.gbapplication2308.WeatherType.*
import java.util.ArrayList


class WeatherAdapter : RecyclerView.Adapter<WeatherAdapter.ViewHolder>() {

    var weatherList: List<Weather> = ArrayList<Weather>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(weatherList[position])
    }

    override fun getItemCount(): Int = weatherList.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(weather: Weather) {
            itemView.findViewById<TextView>(R.id.town).text = weather.town
            itemView.findViewById<TextView>(R.id.temp).text = "${weather.temperature}°"

            itemView.findViewById<TextView>(R.id.space)
                .setBackgroundColor(getColor(RAINY))
        }


        private fun getColor(type: WeatherType): Int = when (type) {
            RAINY -> Color.BLUE
            CLOUDY -> Color.GRAY
            SUNNY -> Color.YELLOW
            MISTY -> Color.GREEN
            SNOWY, HAILY -> Color.RED
            else -> Color.BLACK
        }

    }
}
