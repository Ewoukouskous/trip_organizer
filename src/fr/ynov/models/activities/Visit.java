package fr.ynov.models.activities;

public class Visit extends Activities{

    public Visit(int id) {
        super(id);
    }

    @Override
    public String toString() {
        return "Visit: " + id;
    }

}
