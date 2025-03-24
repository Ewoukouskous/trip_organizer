package fr.ynov.models.transport;

import java.time.LocalDate;

public abstract class TransportType {

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

}
