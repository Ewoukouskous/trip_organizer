package fr.ynov.models.accomodation;

import java.time.LocalDate;

public class Hostel extends Accomodation {

    public  Hostel(int price, String address, LocalDate beginDate, LocalDate endDate) {
        super(price, address, beginDate, endDate);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + ", " + beginDate + " -> " + endDate + ", address: " + address + ", price: " + price;
    }

}
