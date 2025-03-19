package fr.ynov.models.activities;

public class Sport extends Activities {

    public Sport(int id) {
        super(id);
    }

    @Override
    public String toString() {
        return "Sport: " + id;
    }

}
