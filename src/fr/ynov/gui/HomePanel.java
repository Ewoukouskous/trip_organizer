package fr.ynov.gui;

import fr.ynov.models.TripOrganizer;

import javax.swing.*;
import java.awt.*;

public class HomePanel extends JPanel {
    public HomePanel(CardLayout cardLayout, JPanel mainPanel, TripOrganizer tripOrganizer, ViewTripPanel viewTripPanel) {
        setLayout(new BorderLayout());
        setBackground(new Color(202, 240, 248));

        Header headerPanel = new Header(cardLayout, mainPanel);

        // Footer Panel
        JPanel footerPanel = new JPanel(new BorderLayout());
        footerPanel.setBackground(new Color(202, 240, 248));
        footerPanel.setPreferredSize(new Dimension(440, 70));

        RoundButton addTripButton = new RoundButton("+");
        addTripButton.setBackground(new Color(0, 51, 102));
        addTripButton.setFont(new Font("Segoe UI", Font.BOLD, 35));
        addTripButton.setForeground(new Color(202, 240, 248));

        footerPanel.add(addTripButton, BorderLayout.EAST);

        // Correction : Ajout de viewTripPanel dans TripsPanel
        TripsPanel tripsPanel = new TripsPanel(tripOrganizer, cardLayout, mainPanel, viewTripPanel);
        tripsPanel.setBorder(BorderFactory.createEmptyBorder(15, 0, 0, 0));
        add(tripsPanel, BorderLayout.CENTER);

        add(headerPanel, BorderLayout.NORTH);
        add(footerPanel, BorderLayout.SOUTH);

        // Button Actions
        addTripButton.addActionListener(e -> cardLayout.show(mainPanel, "AddTrip"));
    }
}
