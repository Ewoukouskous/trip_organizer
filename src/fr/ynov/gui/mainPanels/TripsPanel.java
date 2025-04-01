package fr.ynov.gui.mainPanels;

import fr.ynov.gui.modified.RoundedPanel;
import fr.ynov.models.TripOrganizer;
import fr.ynov.models.Trip;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class TripsPanel extends JPanel {
    private final TripOrganizer tripOrganizer;
    private final CardLayout cardLayout;
    private final JPanel mainPanel;
    private final ViewTripPanel viewTripPanel;

    public TripsPanel(TripOrganizer tripOrganizer, CardLayout cardLayout, JPanel mainPanel, ViewTripPanel viewTripPanel) {        this.tripOrganizer = tripOrganizer;
        this.cardLayout = cardLayout;
        this.mainPanel = mainPanel;
        this.viewTripPanel = viewTripPanel;

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(new Color(202, 240, 248));

        updateTrips();
    }

        // This function will update the trip list everytime we go on the home page
    public void updateTrips() {
        removeAll();

        List<Trip> trips = tripOrganizer.getTrips();
        for (Trip trip : trips) {
            add(createTripCard(trip));
            add(Box.createVerticalStrut(15));
        }

        revalidate();
        repaint();
    }

        // This function will create a card for the trip that contains an icon, the departure and the arrival and the trip dates
    private JPanel createTripCard(Trip trip) {
        RoundedPanel tripPanel = new RoundedPanel(20);
        tripPanel.setPreferredSize(new Dimension(350, 100));
        tripPanel.setBackground(Color.WHITE);
        tripPanel.setMaximumSize(new Dimension(350, 100));

        JLabel imageLabel = new JLabel();
        imageLabel.setPreferredSize(new Dimension(80, 80));
        imageLabel.setOpaque(true);
        imageLabel.setBackground(Color.LIGHT_GRAY);
        imageLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel textPanel = new JPanel(new GridLayout(2, 1));
        textPanel.setBackground(Color.WHITE);
        textPanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));

        JLabel destinationLabel = new JLabel(trip.getDeparture() + ", " + trip.getArrival());
        destinationLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
        destinationLabel.setForeground(Color.BLACK);

        JLabel dateLabel = new JLabel(trip.getBeginDate() + " - " + trip.getEndDate());
        dateLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        dateLabel.setForeground(Color.DARK_GRAY);

        textPanel.add(destinationLabel);
        textPanel.add(dateLabel);

        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.X_AXIS));
        contentPanel.setBackground(Color.WHITE);
        contentPanel.add(imageLabel);
        contentPanel.add(Box.createRigidArea(new Dimension(50, 0)));
        contentPanel.add(textPanel);

        tripPanel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        tripPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("Trip sélectionné: " + trip.getDeparture() + " → " + trip.getArrival());

                viewTripPanel.setTripDetails(trip);
                System.out.println("Mise à jour du ViewTripPanel avec : " + trip.getDeparture() + " → " + trip.getArrival());

                cardLayout.show(mainPanel, "viewTrip");
                System.out.println("Changement de page réussi !");
            }
        });

        tripPanel.add(contentPanel, BorderLayout.CENTER);

        return tripPanel;
    }
}