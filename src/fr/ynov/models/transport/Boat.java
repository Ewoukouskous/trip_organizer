package fr.ynov.models.transport;

import java.time.LocalDate;

public class Boat extends TransportType {

    public Boat(int id, int price, LocalDate date) {
        super(id, price, date);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + ", " + date.toString() + ", price: " + price;
    }

}
