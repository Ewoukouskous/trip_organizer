package fr.ynov.gui.mainPanels;

import fr.ynov.models.TripOrganizer;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    public MainFrame(TripOrganizer tripOrganizer) {

        setTitle("Trip Organizer");
        setSize(450, 800);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            // The card layout will be a sort of "manager" which will display the selected "pages" when the code ask for it
        CardLayout cardLayout = new CardLayout();
        JPanel mainPanel = new JPanel(cardLayout);

            // Here, there's all the pages I will use
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