package fr.ynov.models.activities;

public class Sport extends Activities {

    public Sport(int id, String name, String city) {
        super(id, name, city);
    }

    @Override
    public String toString() {
        return "Sport: " + id +   ", name: " + name +  ", city: " + city + ", weather: " +  weather;
    }

}
