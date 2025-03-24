package fr.ynov.models.transport;

import java.time.LocalDate;

public class Car extends TransportType {

    public Car(int id, int price, LocalDate date) {
        super(id, price, date);
    }

    @Override
    public String toString() {
        return "Car: " + id;
    }

}
