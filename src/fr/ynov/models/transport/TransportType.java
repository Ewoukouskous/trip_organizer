package fr.ynov.models.transport;

public abstract class TransportType {

    protected int id;
    protected int price;

    public TransportType(int id, int price) {
        this.id = id;
        this.price = price;
    }

        // GETTERS

    public int getPrice() {
        return price;
    }

}
