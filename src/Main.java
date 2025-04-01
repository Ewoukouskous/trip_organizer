import fr.ynov.gui.mainPanels.MainFrame;
import fr.ynov.models.Trip;
import fr.ynov.models.TripOrganizer;
import fr.ynov.models.accomodation.Airbnb;
import fr.ynov.models.accomodation.Hostel;
import fr.ynov.models.activities.Entertainement;
import fr.ynov.models.activities.Sport;
import fr.ynov.models.activities.Visit;
import fr.ynov.models.transport.Plane;
import fr.ynov.models.transport.Train;

import javax.swing.*;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        TripOrganizer tripOrganizer = new TripOrganizer();

        Trip tokyo = new Trip("Toulouse", "Tokyo", LocalDate.now(), LocalDate.now().plusDays(14));

        Plane plane = new Plane(1, 722, LocalDate.now());
        Airbnb airbnb = new Airbnb(72, "2 rue du temple", LocalDate.now().plusDays(1), LocalDate.now().plusDays(14));
        Sport baseball = new Sport(1, "Baseball sur toit", "Tokyo", 12, LocalDate.now().plusDays(3));
        Entertainement gachapon = new Entertainement(1, "Perdre tout aux gachapon", "Tokyo", 50, LocalDate.now().plusDays(2));
        Visit teamlabPlanet = new Visit(1, "Teamlab Planet", "Tokyo", 24, LocalDate.now().plusDays(4));
        Visit shibuya = new Visit(1, "Quartier de Shibuya", "Shibuya", 0, LocalDate.now().plusDays(5));
        Train toOsaka = new Train(1, 42, LocalDate.now().plusDays(6));
        Entertainement chefSushi = new Entertainement(1, "Manger chez un chef sushi", "Osaka", 25, LocalDate.now().plusDays(6));
        Hostel hotelCapsule = new Hostel(45, "65 chemin des sushi", LocalDate.now().plusDays(6), LocalDate.now().plusDays(7));
        Train toTokyo = new Train(1, 42, LocalDate.now().plusDays(7));

        tokyo.addTransportType(plane);
        tokyo.addAccomodation(airbnb);
        tokyo.addActivity(baseball);
        tokyo.addActivity(gachapon);
        tokyo.addActivity(teamlabPlanet);
        tokyo.addActivity(shibuya);
        tokyo.addTransportType(toOsaka);
        tokyo.addActivity(chefSushi);
        tokyo.addAccomodation(hotelCapsule);
        tokyo.addTransportType(toTokyo);

        tripOrganizer.addTrip(tokyo);

        SwingUtilities.invokeLater(() -> new MainFrame(tripOrganizer));

    }

}
