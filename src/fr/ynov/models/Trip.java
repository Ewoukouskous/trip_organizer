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
        this.activitiesList = new ArrayList<>();
    }

    public List<String> displayTravelersName() {
        for  (Travelers traveler : travelersList) {
            travelersNameList.add(traveler.getName());
        }
        return travelersNameList;
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

    public void populateActivitiesList() {
        assert this.activitiesList != null;
        this.activitiesList.clear();

        for (Travelers traveler : travelersList) {
            this.activitiesList.addAll(traveler.getActivities());
        }
    }

    public String getDeparture() {
        return departure;
    }

    public String getArrival() {
        return arrival;
    }

    public LocalDate getBeginDate() {
        return beginDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public List<TransportType>  getTransportsList() {
        return transportsList;
    }

    public List<Accomodation>  getAccomodationsList() {
        return accomodationsList;
    }

    public  List<Activities>  getActivitiesList() {
        return activitiesList;
    }

    public List<Travelers> getTravelersList() {
        return travelersList;
    }

    public void setActivitiesList(List<Travelers> travelersList) {
        for (Travelers traveler : travelersList) {
            this.activitiesList.addAll(traveler.getActivities());
        }
    }

    @Override
    public String toString() {
        return departure + " -> " + arrival;
    }
}
