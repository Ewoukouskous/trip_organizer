package fr.ynov.gui.tripEditor;

import fr.ynov.gui.AddTripPanel;
import fr.ynov.gui.Button;
import fr.ynov.gui.HomePanel;
import fr.ynov.models.Trip;
import fr.ynov.models.TripOrganizer;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Arrays;

public class CreateTripFrame extends JFrame {
    private JTextField departureField, arrivalField, beginDateField, endDateField;
    private JButton createButton, cancelButton;

    public CreateTripFrame(TripOrganizer tripOrganizer, JPanel mainPanel, HomePanel homePanel, AddTripPanel addTripPanel) {
        setTitle("Créer un Nouveau Voyage");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setBackground(new Color(202, 240, 248));
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel titleLabel = new JLabel("Créer un Nouveau Voyage", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2;
        add(titleLabel, gbc);

        gbc.gridwidth = 1;
        gbc.gridy++;
        add(new JLabel("Départ :"), gbc);
        departureField = new JTextField();
        gbc.gridx = 1;
        add(departureField, gbc);

        gbc.gridx = 0; gbc.gridy++;
        add(new JLabel("Arrivée :"), gbc);
        arrivalField = new JTextField();
        gbc.gridx = 1;
        add(arrivalField, gbc);

        gbc.gridx = 0; gbc.gridy++;
        add(new JLabel("Date début (YYYY-MM-DD) :"), gbc);
        beginDateField = new JTextField();
        gbc.gridx = 1;
        add(beginDateField, gbc);

        gbc.gridx = 0; gbc.gridy++;
        add(new JLabel("Date fin (YYYY-MM-DD) :"), gbc);
        endDateField = new JTextField();
        gbc.gridx = 1;
        add(endDateField, gbc);

        createButton = new Button("Créer");
        createButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
        createButton.setBackground(new Color(0, 123, 255));
        createButton.setForeground(Color.WHITE);
        createButton.setFocusPainted(false);
        createButton.addActionListener(e -> {
            createTrip(tripOrganizer, mainPanel, homePanel);
            homePanel.refreshTripsPanel();
            addTripPanel.updateTripList();
        });

        cancelButton = new Button("Annuler");
        cancelButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
        cancelButton.setBackground(new Color(220, 53, 69));
        cancelButton.setForeground(Color.WHITE);
        cancelButton.setFocusPainted(false);
        cancelButton.addActionListener(e -> dispose());

        gbc.gridx = 0; gbc.gridy++;
        gbc.gridwidth = 1;
        add(createButton, gbc);
        gbc.gridx = 1;
        add(cancelButton, gbc);

        setVisible(true);
    }

    private void createTrip(TripOrganizer tripOrganizer, JPanel mainPanel, HomePanel homePanel) {
        try {
            String departure = departureField.getText();
            String arrival = arrivalField.getText();
            LocalDate beginDate = LocalDate.parse(beginDateField.getText());
            LocalDate endDate = LocalDate.parse(endDateField.getText());

            if (departure.isEmpty() || arrival.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Veuillez remplir tous les champs !", "Erreur", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (beginDate.isAfter(endDate)) {
                JOptionPane.showMessageDialog(this, "La date de début doit être avant la date de fin !", "Erreur", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Trip newTrip = new Trip(1, departure, arrival, beginDate, endDate);
            tripOrganizer.addTrip(newTrip);
            homePanel.updateTripComboBox();

            JOptionPane.showMessageDialog(this, "Voyage créé avec succès !", "Succès", JOptionPane.INFORMATION_MESSAGE);
            dispose();

            Component homeComp = Arrays.stream(mainPanel.getComponents())
                    .filter(c -> "homePanel".equals(c.getName()))
                    .findFirst()
                    .orElse(null);

            if (homeComp instanceof HomePanel) {
                homePanel = (HomePanel) homeComp;
                homePanel.refreshTripsPanel();
                homePanel.revalidate();
                homePanel.repaint();
            }
        } catch (DateTimeParseException ex) {
            JOptionPane.showMessageDialog(this, "Format de date incorrect ! Utilisez YYYY-MM-DD.", "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }
}