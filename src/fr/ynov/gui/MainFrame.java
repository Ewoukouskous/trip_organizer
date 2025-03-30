package fr.ynov.gui;

import fr.ynov.models.TripOrganizer;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private CardLayout cardLayout;
    private JPanel mainPanel;
    private TripOrganizer tripOrganizer;

    public MainFrame(TripOrganizer tripOrganizer) {
        this.tripOrganizer = tripOrganizer;

        setTitle("Trip Organizer");
        setSize(450, 800);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        ViewTripPanel viewTripPanel = new ViewTripPanel(cardLayout, mainPanel, tripOrganizer);
        HomePanel homePanel = new HomePanel(cardLayout, mainPanel, tripOrganizer, viewTripPanel);
        AddTripPanel addTripPanel = new AddTripPanel(cardLayout, mainPanel, tripOrganizer, homePanel);

        mainPanel.add(homePanel, "home");
        mainPanel.add(addTripPanel, "addTrip");
        mainPanel.add(viewTripPanel, "viewTrip");

        System.out.println("Panels ajoutés : ");
        for (Component comp : mainPanel.getComponents()) {
            System.out.println(comp.getClass().getName());
        }

        add(mainPanel);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}