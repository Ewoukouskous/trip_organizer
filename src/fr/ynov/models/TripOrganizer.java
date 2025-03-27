package fr.ynov.models;

import fr.ynov.models.accomodation.Accomodation;
import fr.ynov.models.activities.Activities;
import fr.ynov.models.transport.TransportType;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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
