package fr.ynov.models.transport;

public abstract class TransportType {

    protected int id;

    public TransportType(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Transport: " + id;
    }

}
