package fr.ynov.models.activities;

public class Visit extends Activities{

    public Visit(int id, String name, String city, int price) {
        super(id, name, city, price);
    }

    @Override
    public String toString() {
        return "Visit: " + id + ", name: " + name + ", city: " + city + ", weather: " +  weather;
    }

}
