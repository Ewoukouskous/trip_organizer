package fr.ynov.models.transport;

public class Boat extends TransportType {

    public Boat(int id) {
        super(id);
    }

    @Override
    public String toString() {
        return "Boat: " + id;
    }

}
