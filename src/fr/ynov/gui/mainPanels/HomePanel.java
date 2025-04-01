package fr.ynov.gui.mainPanels;

import fr.ynov.gui.utils.Header;
import fr.ynov.gui.modified.RoundButton;
import fr.ynov.models.Trip;
import fr.ynov.models.TripOrganizer;

import javax.swing.*;
import java.awt.*;

public class HomePanel extends JPanel {

    private final CardLayout cardLayout;
    private final JPanel mainPanel;
    private final TripOrganizer tripOrganizer;
    private final ViewTripPanel viewTripPanel;

    private TripsPanel tripsPanel;
    private final JComboBox<Trip> tripComboBox;

    public HomePanel(CardLayout cardLayout, JPanel mainPanel, TripOrganizer tripOrganizer, ViewTripPanel viewTripPanel) {
        this.cardLayout = cardLayout;
        this.mainPanel = mainPanel;
        this.tripOrganizer = tripOrganizer;
        this.viewTripPanel = viewTripPanel;

        setLayout(new BorderLayout());
        setBackground(new Color(202, 240, 248));
        setName("homePanel");

        Header headerPanel = new Header(cardLayout, mainPanel);

        // Footer avec bouton d'ajout
        JPanel footerPanel = new JPanel(new BorderLayout());
        footerPanel.setBackground(new Color(202, 240, 248));
        footerPanel.setPreferredSize(new Dimension(440, 70));

        RoundButton addTripButton = new RoundButton("+");
        addTripButton.setBackground(new Color(0, 51, 102));
        addTripButton.setFont(new Font("Segoe UI", Font.BOLD, 35));
        addTripButton.setForeground(new Color(202, 240, 248));
        footerPanel.add(addTripButton, BorderLayout.EAST);

        tripComboBox = new JComboBox<>();
        updateTripComboBox();

        JPanel comboBoxPanel = new JPanel();
        comboBoxPanel.add(new JLabel("Voyages:"));
        comboBoxPanel.add(tripComboBox);

        add(comboBoxPanel, BorderLayout.NORTH);

        tripsPanel = new TripsPanel(tripOrganizer, cardLayout, mainPanel, viewTripPanel);
        tripsPanel.setBorder(BorderFactory.createEmptyBorder(15, 0, 0, 0));

        add(headerPanel, BorderLayout.NORTH);
        add(tripsPanel, BorderLayout.CENTER);
        add(footerPanel, BorderLayout.SOUTH);

        addTripButton.addActionListener(e -> cardLayout.show(mainPanel, "addTrip"));
    }

        // With this function we will update the panel who display all the trips
    public void refreshTripsPanel() {
        remove(tripsPanel);

        tripsPanel = new TripsPanel(this.tripOrganizer, cardLayout, mainPanel, viewTripPanel);
        tripsPanel.setBorder(BorderFactory.createEmptyBorder(15, 0, 0, 0));

        add(tripsPanel, BorderLayout.CENTER);

        updateTripComboBox();

        revalidate();
        repaint();
    }

    public void updateTripComboBox() {
        tripComboBox.removeAllItems();
        for (Trip trip : this.tripOrganizer.getTrips()) {
            tripComboBox.addItem(trip);
        }
    }
}
