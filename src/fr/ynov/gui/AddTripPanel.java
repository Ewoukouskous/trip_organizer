package fr.ynov.gui;

import javax.swing.*;
import java.awt.*;

public class AddTripPanel extends JPanel {

    public AddTripPanel(CardLayout cardLayout, JPanel mainPanel) {
        setLayout(new BorderLayout());
        setBackground(new Color(202, 240, 248));

        // Header Panel
        Header headerPanel = new Header(cardLayout, mainPanel);
        add(headerPanel, BorderLayout.NORTH);

        JLabel tempLabel = new JLabel("Temp Trip", SwingConstants.CENTER);
        add(tempLabel, BorderLayout.CENTER);
    }
}
