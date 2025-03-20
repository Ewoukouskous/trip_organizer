package fr.ynov.models;

import fr.ynov.models.accomodation.Accomodation;
import fr.ynov.models.activities.Activities;
import fr.ynov.models.transport.TransportType;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.time.temporal.ChronoUnit;

public class Trip {

    private int id;
    private String departure;
    private String arrival;
    private LocalDate beginDate;
    private LocalDate endDate;
    private List<Travelers> travelersList;
    private List<String> travelersNameList;
    private List<TransportType> transportsList;
    private List<Accomodation>  accomodationsList;
    private List<Activities>  activitiesList;

    public Trip(int id, String departure, String arrival, LocalDate beginDate, LocalDate endDate) {
        this.id = id;
        this.departure = departure;
        this.arrival = arrival;
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.travelersNameList = new ArrayList<>();
        this.travelersList = new ArrayList<>();
        this.transportsList = new ArrayList<>();
        this.accomodationsList = new ArrayList<>();
    }

    public List<String> displayTravelersName() {
        for  (Travelers traveler : travelersList) {
            travelersNameList.add(traveler.getName());
        }
        return travelersNameList;
    }

    public void displayTrip() {
        System.out.println("Trip ID: " + id);
        System.out.println("Departure: " + departure + " Arrival: " + arrival);
        System.out.println("Begin Date: " + beginDate + " End Date: " + endDate);
        System.out.println("Travelers name: " + displayTravelersName());
        System.out.println("Travelers:  " + travelersList);
        System.out.println("Transports: " + transportsList);
        System.out.println("Accommodations: " + accomodationsList);
        System.out.println("Activities price: " + calculateAllActivities());
        System.out.println("Accommodations price: " + calculateAllAccomodations());
        System.out.println("Transport price: " + calculateAllTransports());
        System.out.println("Total price: " + calculateTotalPrice());
    }

    public void addTravelers(Travelers travelers) {
        travelersList.add(travelers);
    }

    public void addTransportType(TransportType transportType) {
        transportsList.add(transportType);
    }

    public void addAccomodation(Accomodation accomodation) {
        accomodationsList.add(accomodation);
    }

    public int calculateAllActivities() {
        int totalActivities = 0;
        for (Travelers traveler : travelersList) {
            for (Activities activities : traveler.getActivities()) {
                totalActivities += activities.getPrice();
            }
        }
        return totalActivities;
    }

    public int calculateAllAccomodations() {
        int totalAccomodations = 0;
        for (Accomodation accomodation : accomodationsList) {
            totalAccomodations += (int) ((accomodation.getPrice() * travelersList.size()) * ChronoUnit.DAYS.between(beginDate, endDate));
        }
        return totalAccomodations;
    }

    public int calculateAllTransports() {
        int totalTransport = 0;
        for (TransportType transport : transportsList) {
            totalTransport += transport.getPrice();
        }
        return totalTransport *  travelersList.size();
    }

    public int calculateTotalPrice() {
        return calculateAllActivities() + calculateAllTransports() + calculateAllAccomodations();
    }

}
