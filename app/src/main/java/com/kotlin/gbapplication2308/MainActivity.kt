package com.kotlin.gbapplication2308

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.MenuItem
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: WeatherAdapter
    private lateinit var counter: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.title = getFullName(packageName, getString(R.string.app_name))

        counter = findViewById(R.id.textView)


        counter.setOnClickListener {
            Toast.makeText(this@MainActivity, "sdfsdf", Toast.LENGTH_LONG).show()
        }

        initAdapter()

        addFilter()
    }

    private fun initAdapter() {
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        adapter = WeatherAdapter()

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
        adapter.weatherList = Repository.weatherList
        setCounter(adapter.weatherList.size)
    }

    fun addFilter() {
        findViewById<EditText>(R.id.editText).addTextChangedListener(object : TextWatcher {

            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable) {
                applyFilter(s.toString())
            }
        })
    }

    fun applyFilter(s: String) {

        val filteredWeatherList: MutableList<Weather> = mutableListOf()

        for (weather in Repository.weatherList) {
            if (weather.town.contains(other = s, ignoreCase = true)) {
                filteredWeatherList.add(weather)
            }
        }

        adapter.weatherList = filteredWeatherList
        setCounter(filteredWeatherList.size)
    }

    private fun setCounter(count: Int) {
        counter.text = if (count == 0) "Нет городов" else "Городов: $count"
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean =
        if (item.itemId == android.R.id.home) {
            onBackPressed()
            true
        } else {
            super.onOptionsItemSelected(item)
        }

}