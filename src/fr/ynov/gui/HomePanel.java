package fr.ynov.gui;

import fr.ynov.models.TripOrganizer;

import javax.swing.*;
import java.awt.*;

public class HomePanel extends JPanel {

    private CardLayout cardLayout;
    private JPanel mainPanel;
    private TripOrganizer tripOrganizer;
    private ViewTripPanel viewTripPanel;

    private Header headerPanel;
    private JPanel footerPanel;
    private TripsPanel tripsPanel;

    public HomePanel(CardLayout cardLayout, JPanel mainPanel, TripOrganizer tripOrganizer, ViewTripPanel viewTripPanel) {
        this.cardLayout = cardLayout;
        this.mainPanel = mainPanel;
        this.tripOrganizer = tripOrganizer;
        this.viewTripPanel = viewTripPanel;

        setLayout(new BorderLayout());
        setBackground(new Color(202, 240, 248));
        setName("homePanel");

        // Initialisation des composants
        headerPanel = new Header(cardLayout, mainPanel);

        footerPanel = new JPanel(new BorderLayout());
        footerPanel.setBackground(new Color(202, 240, 248));
        footerPanel.setPreferredSize(new Dimension(440, 70));

        RoundButton addTripButton = new RoundButton("+");
        addTripButton.setBackground(new Color(0, 51, 102));
        addTripButton.setFont(new Font("Segoe UI", Font.BOLD, 35));
        addTripButton.setForeground(new Color(202, 240, 248));

        footerPanel.add(addTripButton, BorderLayout.EAST);

        // Initialisation du TripsPanel
        tripsPanel = new TripsPanel(tripOrganizer, cardLayout, mainPanel, viewTripPanel);
        tripsPanel.setBorder(BorderFactory.createEmptyBorder(15, 0, 0, 0));

        // Ajout des composants
        add(headerPanel, BorderLayout.NORTH);
        add(tripsPanel, BorderLayout.CENTER);
        add(footerPanel, BorderLayout.SOUTH);

        // Button Actions
        addTripButton.addActionListener(e -> cardLayout.show(mainPanel, "addTrip"));
    }

    public void refreshTripsPanel() {
        // Supprime uniquement l'ancien TripsPanel
        remove(tripsPanel);

        // Crée un nouveau TripsPanel
        tripsPanel = new TripsPanel(this.tripOrganizer, cardLayout, mainPanel, viewTripPanel);
        tripsPanel.setBorder(BorderFactory.createEmptyBorder(15, 0, 0, 0));

        // Ajoute le nouveau TripsPanel
        add(tripsPanel, BorderLayout.CENTER);

        // Rafraîchissement
        revalidate();
        repaint();
    }
}
