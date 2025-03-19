package fr.ynov.models.accomodation;

import java.util.Date;

public class Airbnb extends Accomodation {

    public Airbnb(int price, String address, Date beginDate, Date endDate) {
        super(price, address, beginDate, endDate);
    }

    @Override
    public String toString() {
        return "price: " + price + ", address: " + address + ", beginDate: " + beginDate + ", endDate: " + endDate;
    }

}
