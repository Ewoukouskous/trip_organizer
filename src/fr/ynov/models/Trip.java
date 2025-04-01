package fr.ynov.models;

import fr.ynov.models.accomodation.Accomodation;
import fr.ynov.models.activities.Activities;
import fr.ynov.models.transport.TransportType;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Trip {

    private final String departure;
    private final String arrival;
    private final LocalDate beginDate;
    private final LocalDate endDate;
    private final List<TransportType> transportsList;
    private final List<Accomodation>  accomodationsList;
    private final List<Activities>  activitiesList;

    public Trip(String departure, String arrival, LocalDate beginDate, LocalDate endDate) {
        this.departure = departure;
        this.arrival = arrival;
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.transportsList = new ArrayList<>();
        this.accomodationsList = new ArrayList<>();
        this.activitiesList = new ArrayList<>();
    }

    public void addTransportType(TransportType transportType) {
        transportsList.add(transportType);
    }

    public void addAccomodation(Accomodation accomodation) {
        accomodationsList.add(accomodation);
    }

    public void addActivity(Activities activity) {activitiesList.add(activity);}

        // GETTERS

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

    @Override
    public String toString() {
        return departure + " -> " + arrival;
    }
}
