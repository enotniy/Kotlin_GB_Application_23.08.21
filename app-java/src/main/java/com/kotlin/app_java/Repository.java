package com.kotlin.app_java;

import java.util.ArrayList;
import java.util.List;

public class Repository {

    public static Repository repository;

    public static Repository getInstance() {
        if (repository == null) {
            repository = new Repository();
        }
        return repository;
    }

    private final List<Weather> weatherList;

    private Repository() {
        this.weatherList = new ArrayList<>();
        weatherList.add(new Weather("Москва", 15));
        weatherList.add(new Weather("Питер"));
        weatherList.add(new Weather("Саратов"));
        weatherList.add(new Weather("Москва", 16));
        weatherList.add(new Weather("Москва", 17));
        weatherList.add(new Weather(12));
    }

    public List<Weather> getWeatherList() {
        return weatherList;
    }
}
