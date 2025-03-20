package fr.ynov.models.activities;

public class Entertainement extends Activities {

    public Entertainement(int id, String name, String city) {
        super(id, name, city);
    }

    @Override
    public String toString() {
        return "Sport: " + id +  ", name: " + name +  ", city: " + city + ", weather: " +  weather;
    }

}
