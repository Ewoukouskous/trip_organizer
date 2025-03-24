package fr.ynov.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Header extends RoundedBottomPanel {

    public Header(CardLayout cardLayout, JPanel mainPanel) {
        super(30);

        setLayout(new BorderLayout());
        setBackground(new Color(0, 119, 182));
        setPreferredSize(new Dimension(440, 100));

        JLabel titleLabel = new JLabel("Trip Organizer", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 35));
        titleLabel.setForeground(new Color(3, 4, 94));

        titleLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        titleLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                cardLayout.show(mainPanel, "Home");
            }
        });

        add(titleLabel, BorderLayout.CENTER);
    }
}