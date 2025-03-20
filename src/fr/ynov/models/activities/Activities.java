package fr.ynov.models.activities;

import fr.ynov.models.WeatherInfo;

public abstract class Activities {

    protected int id;
    protected String name;
    protected static String city;
    protected String weather;

    public Activities(int id, String name, String city) {
        this.id = id;
        this.name = name;
        Activities.city = city;
        this.weather = new WeatherInfo().toString();
    }

        // GETTERS

    public static String getCity() {
        return city;
    }

}
