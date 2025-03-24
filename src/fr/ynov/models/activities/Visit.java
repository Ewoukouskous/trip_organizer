package fr.ynov.models.activities;

import java.time.LocalDate;

public class Visit extends Activities{

    public Visit(int id, String name, String city, int price, LocalDate date) {
        super(id, name, city, price, date);
    }

    @Override
    public String toString() {
        return "Visit: " + id + ", name: " + name + ", city: " + city + ", weather: " +  weather;
    }

}
