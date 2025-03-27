package fr.ynov.models.activities;

import java.time.LocalDate;

public class Entertainement extends Activities {

    public Entertainement(int id, String name, String city, int price, LocalDate date) {
        super(id, name, city, price, date);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + ", " + date.toString() + ", Name: " + name + ", City: " + city + ", Price: " + price ;
    }

}
