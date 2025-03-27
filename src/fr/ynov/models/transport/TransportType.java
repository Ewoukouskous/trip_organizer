package fr.ynov.models.transport;

import fr.ynov.models.Date;

import java.time.LocalDate;

public abstract class TransportType implements Date {

    protected int id;
    protected int price;
    protected LocalDate date;

    public TransportType(int id, int price,  LocalDate date) {
        this.id = id;
        this.price = price;
        this.date = date;
    }

        // GETTERS

    public int getPrice() {
        return price;
    }

    @Override
    public LocalDate getDate() {
        return  date;
    }
}
