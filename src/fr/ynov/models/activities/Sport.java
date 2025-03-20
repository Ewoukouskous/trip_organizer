package fr.ynov.models.activities;

public class Sport extends Activities {

    public Sport(int id, String name) {
        super(id, name);
    }

    @Override
    public String toString() {
        return "Sport: " + id +   ", name: " + name;
    }

}
