package fr.ynov.models.activities;

import fr.ynov.models.Date;
import java.time.LocalDate;

public class Activities implements Date {

    protected int id;
    protected String name;
    protected static String city;
    protected int price;
    protected LocalDate date;

    public Activities(int id, String name, String city, int price, LocalDate date) {
        this.id = id;
        this.name = name;
        Activities.city = city;
        this.price = price;
        this.date = date;
    }

        // GETTERS

    public int getPrice() {
        return price;
    }

    @Override
    public LocalDate getDate() {
        return date;
    }
}
