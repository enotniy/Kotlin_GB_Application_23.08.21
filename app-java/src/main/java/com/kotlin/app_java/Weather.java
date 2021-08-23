package com.kotlin.app_java;

public class Weather {

    private String town;
    private Integer temperature;

    public Weather(String town, Integer temperature) {
        this.town = town;
        this.temperature = temperature;
    }

    public Weather(String town) {
        this(town, 15);
    }

    public Weather() {
        this("Москва");
    }

    public Weather(Integer temperature) {
        this("Москва", temperature);
    }

    public String getTown() {
        return town;
    }

    public Integer getTemperature() {
        return temperature;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public void setTemperature(Integer temperature) {
        this.temperature = temperature;
    }
}
