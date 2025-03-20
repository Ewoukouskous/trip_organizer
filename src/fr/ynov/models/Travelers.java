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

    public void joinActivity(Activities activities) {
        List<Activities>  activitiesList = getActivities();
        activitiesList.add(activities);
        setActivities(activitiesList);
    }

    public void displayActivities() {
        for (Activities activities : getActivities()) {
            System.out.println(activities.toString());
        }
    }

        // GETTERS

    public List<Activities> getActivities() {
        return activities;
    }

        // SETTERS

    public void setActivities(List<Activities> activities) {
        this.activities = activities;
    }

}
