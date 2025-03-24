package fr.ynov.gui;

import fr.ynov.models.TripOrganizer;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private CardLayout cardLayout;
    private JPanel mainPanel;
    private TripOrganizer tripOrganizer;

    public MainFrame(final TripOrganizer tripOrganizer) {
        this.tripOrganizer = tripOrganizer;

        // Init the Frame
        setTitle("TripOrganizer");
        setSize(440, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Initialize CardLayout
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        // Créer les pages
        ViewTripPanel viewTripPanel = new ViewTripPanel(cardLayout, mainPanel);
        HomePanel homePanel = new HomePanel(cardLayout, mainPanel, tripOrganizer, viewTripPanel);
        AddTripPanel addTripPanel = new AddTripPanel(cardLayout, mainPanel);

        // Ajouter les Panels au CardLayout
        mainPanel.add(homePanel, "Home");
        mainPanel.add(addTripPanel, "AddTrip");
        mainPanel.add(viewTripPanel, "ViewTrip");

        add(mainPanel);
        setVisible(true);
    }
}
