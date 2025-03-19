package fr.ynov.models.transport;

public class Car extends TransportType {

    public Car(int id) {
        super(id);
    }

    @Override
    public String toString() {
        return "Car: " + id;
    }

}
