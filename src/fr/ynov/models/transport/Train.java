package fr.ynov.models.transport;

import java.time.LocalDate;

public class Train extends TransportType {

    public Train(int id, int price, LocalDate date) {
        super(id, price, date);
    }

    @Override
    public String toString() {
        return "Train: " + id;
    }

}
