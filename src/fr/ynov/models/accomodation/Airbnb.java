package fr.ynov.models.accomodation;

import java.time.LocalDate;
import java.util.Date;

public class Airbnb extends Accomodation {

    public Airbnb(int price, String address, LocalDate beginDate, LocalDate endDate) {
        super(price, address, beginDate, endDate);
    }

    @Override
    public String toString() {
        return "price: " + price + ", address: " + address + ", beginDate: " + beginDate + ", endDate: " + endDate;
    }

}
