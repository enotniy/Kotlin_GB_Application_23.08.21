package com.kotlin.gbapplication2308



object Repository {
    val weatherList: List<Weather> = listOf(
        Weather(),
        Weather("Питер", 3),
        Weather(town = "Питер", 1),
        Weather(town = "Саратов"),
        Weather(temperature = 0),
        Weather(temperature = 2, town = "Омск"),
    )
}