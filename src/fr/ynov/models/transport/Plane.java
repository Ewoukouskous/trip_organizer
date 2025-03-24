package fr.ynov.models.transport;

import java.time.LocalDate;

public class Plane extends TransportType {

    public Plane(int id, int price, LocalDate date) {
        super(id, price, date);
    }

    @Override
    public String toString() {
        return "Plane: " + id;
    }

}
