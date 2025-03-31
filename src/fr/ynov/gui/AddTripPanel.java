package fr.ynov.gui;

import fr.ynov.gui.tripEditor.AccomodationEditorFrame;
import fr.ynov.gui.tripEditor.ActivityEditorFrame;
import fr.ynov.gui.tripEditor.CreateTripFrame;
import fr.ynov.gui.tripEditor.TransportEditorFrame;
import fr.ynov.models.Trip;
import fr.ynov.models.TripOrganizer;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class AddTripPanel extends JPanel {
    private final TripOrganizer tripOrganizer;
    private final JComboBox<Trip> tripComboBox;

    public AddTripPanel(CardLayout cardLayout, JPanel mainPanel, TripOrganizer tripOrganizer, HomePanel homePanel) {
        this.tripOrganizer = tripOrganizer;

        setLayout(new BorderLayout());
        setBackground(new Color(202, 240, 248));

        // Header
        Header header = new Header(cardLayout, mainPanel);
        add(header, BorderLayout.NORTH);

        // Conteneur principal
        JPanel bodyPanel = new JPanel(new GridBagLayout());
        bodyPanel.setBackground(new Color(202, 240, 248));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;

        // Panel principal (sélection voyage)
        JPanel topPanel = new JPanel(new GridBagLayout());
        topPanel.setBackground(new Color(202, 240, 248));
        GridBagConstraints topGbc = new GridBagConstraints();
        topGbc.insets = new Insets(5, 5, 5, 5);
        topGbc.gridx = 0;
        topGbc.gridy = 0;
        topGbc.anchor = GridBagConstraints.CENTER;

        JLabel titleLabel = new JLabel("Sélectionnez un voyage :");
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));
        topPanel.add(titleLabel, topGbc);

        tripComboBox = new JComboBox<>();
        tripComboBox.setPreferredSize(new Dimension(250, 30));
        updateTripList();
        topGbc.gridy++;
        topPanel.add(tripComboBox, topGbc);

        Button tripButton = new Button("Créer un voyage");
        tripButton.addActionListener(e -> new CreateTripFrame(tripOrganizer, mainPanel, homePanel, this));
        topGbc.gridy++;
        topPanel.add(tripButton, topGbc);

        gbc.gridy = 0;
        bodyPanel.add(topPanel, gbc);

        // Espacement
        gbc.gridy++;
        bodyPanel.add(Box.createVerticalStrut(20), gbc);

        // Panel des boutons d'actions (Centré avec GridBagLayout)
        JPanel buttonPanel = new JPanel(new GridBagLayout());
        buttonPanel.setBackground(new Color(202, 240, 248));

        GridBagConstraints btnGbc = new GridBagConstraints();
        btnGbc.insets = new Insets(10, 5, 10, 5);
        btnGbc.gridx = 0;
        btnGbc.gridy = 0;
        btnGbc.anchor = GridBagConstraints.CENTER;

        Button transportButton = new Button("Ajouter un transport");
        transportButton.addActionListener(e -> openTransportEditor());
        buttonPanel.add(transportButton, btnGbc);

        btnGbc.gridy++;
        Button accomodationButton = new Button("Ajouter un hébergement");
        accomodationButton.addActionListener(e -> openAccomodationEditor());
        buttonPanel.add(accomodationButton, btnGbc);

        btnGbc.gridy++;
        Button activiyButton = new Button("Ajouter une activité");
        activiyButton.addActionListener(e -> openActivityEditor());
        buttonPanel.add(activiyButton, btnGbc);

        gbc.gridy++;
        bodyPanel.add(buttonPanel, gbc);

        add(bodyPanel, BorderLayout.CENTER);
    }

    public void updateTripList() {
        tripComboBox.removeAllItems();
        List<Trip> trips = tripOrganizer.getTrips();
        for (Trip trip : trips) {
            tripComboBox.addItem(trip);
        }
    }

    private void openTransportEditor() {
        Trip selectedTrip = (Trip) tripComboBox.getSelectedItem();
        if (selectedTrip != null) {
            new TransportEditorFrame(selectedTrip);
        }
    }

    private void openAccomodationEditor() {
        Trip selectedTrip = (Trip) tripComboBox.getSelectedItem();
        if (selectedTrip != null) {
            new AccomodationEditorFrame(selectedTrip);
        }
    }

    private void openActivityEditor() {
        Trip selectedTrip = (Trip) tripComboBox.getSelectedItem();
        if (selectedTrip != null) {
            new ActivityEditorFrame(selectedTrip);
        }
    }
}
