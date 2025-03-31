package fr.ynov.models;

import fr.ynov.models.activities.Activities;

import java.util.ArrayList;
import java.util.List;

public class Travelers {

    private final String name;
    private final List<Activities> activities;

    public Travelers(String name) {
        this.name = name;
        this.activities = new ArrayList<>();
    }

        // GETTERS

    public List<Activities> getActivities() {
        return activities;
    }

    public String getName(){
        return name;
    }
}
