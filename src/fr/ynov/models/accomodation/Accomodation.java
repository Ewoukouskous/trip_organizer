package fr.ynov.models.accomodation;

import java.util.Date;

public abstract class Accomodation {

    protected int price;
    protected String address;
    protected Date beginDate;
    protected Date endDate;

    public Accomodation(int price, String address, Date beginDate, Date endDate) {
        this.price = price;
        this.address = address;
        this.beginDate = beginDate;
        this.endDate = endDate;
    }

        // GETTERS

    public int getPrice() {
        return price;
    }

}
