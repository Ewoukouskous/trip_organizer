package fr.ynov.gui;

import fr.ynov.models.Trip;
import fr.ynov.models.TripOrganizer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Arrays;

public class CreateTripFrame extends JFrame {

    private JTextField departureField, arrivalField, beginDateField, endDateField;
    private JButton createButton, cancelButton;

    public CreateTripFrame(TripOrganizer tripOrganizer, JPanel mainPanel, HomePanel homePanel, AddTripPanel addTripPanel) {
        setTitle("Créer un Nouveau Voyage");
        setSize(400, 300);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(5, 2, 10, 10));

        panel.add(new JLabel("Départ:"));
        departureField = new JTextField();
        panel.add(departureField);

        panel.add(new JLabel("Arrivée:"));
        arrivalField = new JTextField();
        panel.add(arrivalField);

        panel.add(new JLabel("Date début (YYYY-MM-DD):"));
        beginDateField = new JTextField();
        panel.add(beginDateField);

        panel.add(new JLabel("Date fin (YYYY-MM-DD):"));
        endDateField = new JTextField();
        panel.add(endDateField);

        createButton = new JButton("Créer");
        cancelButton = new JButton("Annuler");

        panel.add(createButton);
        panel.add(cancelButton);

        add(panel, BorderLayout.CENTER);

        createButton.addActionListener(e -> {
            createTrip(tripOrganizer, mainPanel, homePanel);
            homePanel.refreshTripsPanel();  // Mise à jour du HomePanel
            addTripPanel.updateTripList();  // Mise à jour du JComboBox dans AddTripPanel
        });

        cancelButton.addActionListener(e -> dispose()); // Ferme la fenêtre

        setVisible(true);
    }

    private void createTrip(TripOrganizer tripOrganizer, JPanel mainPanel, HomePanel homePanel) {
        try {
            String departure = departureField.getText();
            String arrival = arrivalField.getText();
            LocalDate beginDate = LocalDate.parse(beginDateField.getText());
            LocalDate endDate = LocalDate.parse(endDateField.getText());

            // Vérification des données
            if (departure.isEmpty() || arrival.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Veuillez remplir tous les champs !", "Erreur", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (beginDate.isAfter(endDate)) {
                JOptionPane.showMessageDialog(this, "La date de début doit être avant la date de fin !", "Erreur", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Création du Trip
            Trip newTrip = new Trip(1, departure, arrival, beginDate, endDate);
            tripOrganizer.addTrip(newTrip);
            homePanel.updateTripComboBox();

            // Confirmation
            System.out.println(tripOrganizer.getTrips());
            JOptionPane.showMessageDialog(this, "Voyage créé avec succès !", "Succès", JOptionPane.INFORMATION_MESSAGE);
            System.out.println(newTrip.getDeparture() + ",  " + newTrip.getArrival());
            dispose();

            // Refaire la page home
            Component homeComp = Arrays.stream(mainPanel.getComponents())
                    .filter(c -> "homePanel".equals(c.getName()))
                    .findFirst()
                    .orElse(null);

            if (homeComp instanceof HomePanel) {
                homePanel = (HomePanel) homeComp;

                // Rafraîchir TripsPanel (qui affiche les voyages)
                homePanel.refreshTripsPanel();

                homePanel.revalidate();
                homePanel.repaint();
            }
        } catch (DateTimeParseException ex) {
            JOptionPane.showMessageDialog(this, "Format de date incorrect ! Utilisez YYYY-MM-DD.", "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }
}
