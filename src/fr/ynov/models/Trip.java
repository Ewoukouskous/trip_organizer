package fr.ynov.models;

import fr.ynov.models.accomodation.Accomodation;
import fr.ynov.models.transport.TransportType;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Trip {

    private int id;
    private String departure;
    private String arrival;
    private Date beginDate;
    private Date endDate;
    private List<Travelers> travelersList;
    private List<String> travelersNameList;
    private List<TransportType> transportsList;
    private List<Accomodation>  accomodationsList;

    public Trip(int id, String departure, String arrival, Date beginDate, Date endDate) {
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

}
