package fr.ynov.models.transport;

public class Plane extends TransportType {

    public Plane(int id) {
        super(id);
    }

    @Override
    public String toString() {
        return "Plane: " + id;
    }

}
