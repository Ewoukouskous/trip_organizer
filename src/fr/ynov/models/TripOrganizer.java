package fr.ynov.models;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TripOrganizer {

    private final List<Trip> trips;

    public TripOrganizer() {
        trips = new ArrayList<>();
    }

    public void addTrip(Trip trip) {
        trips.add(trip);
    }

    public List<Trip> getTrips() {
        return trips;
    }

    public List<Object> getSortedTimelineElements(Trip trip) {
        List<Object> elements = new ArrayList<>();

        trip.setActivitiesList(trip.getTravelersList());

        elements.addAll(trip.getTransportsList());
        elements.addAll(trip.getAccomodationsList());
        elements.addAll(trip.getActivitiesList());

        elements.sort(Comparator.comparing(element -> ((Date) element).getDate()));

        return elements;
    }

}
