package fr.ynov.models.transport;

public class Plane extends TransportType {

    public Plane(int id, int price) {
        super(id, price);
    }

    @Override
    public String toString() {
        return "Plane: " + id;
    }

}
