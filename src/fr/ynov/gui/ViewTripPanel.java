package fr.ynov.gui;

import fr.ynov.models.Trip;

import javax.swing.*;
import java.awt.*;

public class ViewTripPanel extends JPanel {
    private JLabel destinationLabel;
    private JLabel dateLabel;
    private CardLayout cardLayout;
    private JPanel mainPanel;

    public ViewTripPanel(CardLayout cardLayout, JPanel mainPanel) {
        this.cardLayout = cardLayout;
        this.mainPanel = mainPanel;

        setLayout(new BorderLayout());
        setBackground(new Color(202, 240, 248));

        Header header = new Header(cardLayout, mainPanel);

        // Labels
        destinationLabel = new JLabel("Destination : ", SwingConstants.CENTER);
        destinationLabel.setFont(new Font("Segoe UI", Font.BOLD, 20));

        dateLabel = new JLabel("Dates : ", SwingConstants.CENTER);
        dateLabel.setFont(new Font("Segoe UI", Font.PLAIN, 16));

        // Contenu
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        contentPanel.setBackground(new Color(202, 240, 248));
        contentPanel.setBorder(BorderFactory.createEmptyBorder(100, 50, 100, 50));

        destinationLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        dateLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        contentPanel.add(destinationLabel);
        contentPanel.add(Box.createVerticalStrut(10));
        contentPanel.add(dateLabel);

        add(header, BorderLayout.NORTH);
        add(contentPanel, BorderLayout.CENTER);
    }

    public void setTripDetails(Trip trip) {
        destinationLabel.setText(trip.getDeparture() + " → " + trip.getArrival());
        dateLabel.setText(trip.getBeginDate() + " - " + trip.getEndDate());
    }
}
