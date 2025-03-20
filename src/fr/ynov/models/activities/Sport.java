package fr.ynov.models.activities;

public class Sport extends Activities {

    public Sport(int id, String name, String city, int price) {
        super(id, name, city, price);
    }

    @Override
    public String toString() {
        return "Sport: " + id +   ", name: " + name +  ", city: " + city + ", weather: " +  weather;
    }

}
