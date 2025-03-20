package fr.ynov.models.transport;

public class Car extends TransportType {

    public Car(int id, int price) {
        super(id, price);
    }

    @Override
    public String toString() {
        return "Car: " + id;
    }

}
