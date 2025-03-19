package fr.ynov.models.transport;

public class Train extends TransportType {

    public Train(int id) {
        super(id);
    }

    @Override
    public String toString() {
        return "Train: " + id;
    }

}
