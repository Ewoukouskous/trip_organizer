package fr.ynov.models.accomodation;

import java.time.LocalDate;

public abstract class Accomodation {

    protected int price;
    protected String address;
    protected LocalDate beginDate;
    protected LocalDate endDate;

    public  Accomodation(int price, String address, LocalDate beginDate, LocalDate endDate) {
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
