import fr.ynov.gui.HomePanel;
import fr.ynov.gui.MainFrame;
import fr.ynov.models.Trip;
import fr.ynov.models.TripOrganizer;

import javax.swing.*;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        TripOrganizer tripOrganizer = new TripOrganizer();

        Trip tokyo = new Trip(1, "Toulouse", "Tokyo", LocalDate.now(), LocalDate.now().plusDays(14));
        Trip tokyo2 = new Trip(1, "Toulouse2", "Tokyo2", LocalDate.now(), LocalDate.now().plusDays(14));

        tripOrganizer.addTrip(tokyo);
        tripOrganizer.addTrip(tokyo2);

        SwingUtilities.invokeLater(() -> {
            new MainFrame(tripOrganizer);
        });

    }

}
