package fr.ynov.models;

import java.util.ArrayList;
import java.util.List;

public class TripOrganizer {

    private List<Trip> trips;

    public TripOrganizer() {
        trips = new ArrayList<>();
    }

    public void addTrip(Trip trip) {
        trips.add(trip);
    }

    public void removeTrip(Trip trip) {
        trips.remove(trip);
    }

    public List<Trip> getTrips() {
        return trips;
    }

    public void displayTrips() {
        for  (Trip trip : trips) {
            trip.displayTrip();
            System.out.println("-=-=-=-=-=-=-=-");
        }
    }

}
