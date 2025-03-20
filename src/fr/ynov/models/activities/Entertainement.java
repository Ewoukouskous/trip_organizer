package fr.ynov.models.activities;

public class Entertainement extends Activities {

    public Entertainement(int id, String name) {
        super(id, name);
    }

    @Override
    public String toString() {
        return "Sport: " + id +  ", name: " + name;
    }

}
