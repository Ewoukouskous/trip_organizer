import fr.ynov.gui.HomePanel;
import fr.ynov.gui.MainFrame;
import fr.ynov.models.Travelers;
import fr.ynov.models.Trip;
import fr.ynov.models.TripOrganizer;
import fr.ynov.models.accomodation.Airbnb;
import fr.ynov.models.accomodation.Hostel;
import fr.ynov.models.activities.Entertainement;
import fr.ynov.models.activities.Sport;
import fr.ynov.models.transport.Plane;

import javax.swing.*;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        TripOrganizer tripOrganizer = new TripOrganizer();

        Trip tokyo = new Trip(1, "Toulouse", "Tokyo", LocalDate.now(), LocalDate.now().plusDays(14));
        Trip tokyo2 = new Trip(1, "Toulouse2", "Tokyo2", LocalDate.now(), LocalDate.now().plusDays(14));

        Travelers nino = new Travelers(1, "Nino", 18);

        Plane plane = new Plane(1, 150, LocalDate.now());
        Hostel hostel = new Hostel(1, "2 rue dqzjdqz", LocalDate.now(), LocalDate.now().plusDays(14));
        Airbnb airbnb = new Airbnb(1, "78 impasse dqbd", LocalDate.now(), LocalDate.now().plusDays(14));
        Entertainement maitreSushi = new Entertainement(1, "Maitre sushi", "Tokyo", 30, LocalDate.now().plusDays(4));

        tokyo.addTransportType(plane);

        tokyo.addAccomodation(hostel);
        tokyo.addAccomodation(airbnb);
        tokyo.addTravelers(nino);
        nino.joinActivity(maitreSushi);

        tripOrganizer.addTrip(tokyo);
        tripOrganizer.addTrip(tokyo2);

        System.out.println(tokyo.getActivitiesList());

        SwingUtilities.invokeLater(() -> {
            new MainFrame(tripOrganizer);
        });

    }

}
