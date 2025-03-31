package fr.ynov.models;

import fr.ynov.models.activities.Activities;

import java.util.ArrayList;
import java.util.List;

public class Travelers {

    private final int id;
    private String name;
    private int age;
    private List<Activities> activities;

    public Travelers(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
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
