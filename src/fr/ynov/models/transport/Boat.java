package fr.ynov.models.transport;

public class Boat extends TransportType {

    public Boat(int id, int price) {
        super(id, price);
    }

    @Override
    public String toString() {
        return "Boat: " + id;
    }

}
