package fr.ynov.models.activities;

public class Visit extends Activities{

    public Visit(int id, String name) {
        super(id, name);
    }

    @Override
    public String toString() {
        return "Visit: " + id +  ", name: " + name;
    }

}
