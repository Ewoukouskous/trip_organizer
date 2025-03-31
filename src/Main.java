import fr.ynov.gui.MainFrame;
import fr.ynov.models.Trip;
import fr.ynov.models.TripOrganizer;

import javax.swing.*;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        TripOrganizer tripOrganizer = new TripOrganizer();

        Trip tokyo = new Trip("Toulouse", "Tokyo", LocalDate.now(), LocalDate.now().plusDays(14));

        tripOrganizer.addTrip(tokyo);

        SwingUtilities.invokeLater(() -> new MainFrame(tripOrganizer));

    }

}
