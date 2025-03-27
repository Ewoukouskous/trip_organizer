package fr.ynov.gui;

import fr.ynov.models.TripOrganizer;

import javax.swing.*;
import java.awt.*;

public class AddTripPanel extends JPanel {

    public AddTripPanel(CardLayout cardLayout, JPanel mainPanel, TripOrganizer tripOrganizer) {
        setLayout(new BorderLayout());
        setBackground(new Color(202, 240, 248));

        // Header Panel
        Header headerPanel = new Header(cardLayout, mainPanel);
        add(headerPanel, BorderLayout.NORTH);

        JButton newTripButton = new JButton("Nouveau Voyage");
        newTripButton.addActionListener(e -> new CreateTripFrame(tripOrganizer, mainPanel));
        add(newTripButton, BorderLayout.SOUTH);

        JLabel tempLabel = new JLabel("Temp Trip", SwingConstants.CENTER);
        add(tempLabel, BorderLayout.CENTER);
    }
}
