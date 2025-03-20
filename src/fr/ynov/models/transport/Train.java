package fr.ynov.models.transport;

public class Train extends TransportType {

    public Train(int id, int price) {
        super(id, price);
    }

    @Override
    public String toString() {
        return "Train: " + id;
    }

}
