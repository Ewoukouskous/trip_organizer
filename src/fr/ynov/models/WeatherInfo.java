package fr.ynov.models;

import fr.ynov.models.activities.Activities;

public class WeatherInfo {

    private final String location;
    private final double temperature;
    private final String condition;

    public WeatherInfo() {
        this.location = Activities.getCity();
        this.temperature = getTemperature();
        this.condition = getCondition();
    }

    private double getTemperature() {
        return Math.round(Math.random() * 40 * 100.0) / 100.0;
    }

    private String getCondition() {
        if (this.temperature <= 10.0) {
            return "rainy";
        } else if (this.temperature <= 30.0) {
            return "cloudy";
        } else {
            return "sunny";
        }
    }

    @Override
    public String toString() {
        return "It's " + temperature + " in " + location + ". For this activity the sky will be " + condition;
    }

}
