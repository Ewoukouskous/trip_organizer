package fr.ynov.models.activities;

import java.time.LocalDate;

public class Sport extends Activities {

    public Sport(int id, String name, String city, int price, LocalDate date) {
        super(id, name, city, price, date);
    }

    @Override
    public String toString() {
        return "Sport: " + id +   ", name: " + name +  ", city: " + city + ", weather: " +  weather;
    }

}
