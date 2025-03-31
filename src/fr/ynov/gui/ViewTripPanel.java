package fr.ynov.gui;

import fr.ynov.models.Trip;
import fr.ynov.models.TripOrganizer;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ViewTripPanel extends JPanel {
    private CardLayout cardLayout;
    private JPanel mainPanel;
    private TripOrganizer tripOrganizer;
    private JPanel timelinePanel;

    public ViewTripPanel(CardLayout cardLayout, JPanel mainPanel, TripOrganizer tripOrganizer) {
        this.cardLayout = cardLayout;
        this.mainPanel = mainPanel;
        this.tripOrganizer = tripOrganizer;

        setLayout(new BorderLayout());
        setBackground(new Color(202, 240, 248));

        Header header = new Header(cardLayout, mainPanel);
        add(header, BorderLayout.NORTH);

        timelinePanel = new JPanel();
        timelinePanel.setLayout(new BoxLayout(timelinePanel, BoxLayout.Y_AXIS));
        timelinePanel.setBackground(new Color(202, 240, 248));
        timelinePanel.setBorder(BorderFactory.createEmptyBorder(20, 50, 50, 50));

        JScrollPane scrollPane = new JScrollPane(timelinePanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.getVerticalScrollBar().setUnitIncrement(10);
        scrollPane.getVerticalScrollBar().setUI(new ModernScrollBarUI());
        scrollPane.setBorder(null);

        add(scrollPane, BorderLayout.CENTER);
    }

    public void setTripDetails(Trip trip) {
        if (trip == null) {
            System.err.println("Erreur : trip est null !");
            return;
        }

        System.out.println("Mise à jour du ViewTripPanel avec : " + trip.getDeparture() + " → " + trip.getArrival());

        timelinePanel.removeAll();

        List<Object> timelineElements = tripOrganizer.getSortedTimelineElements(trip);

        if (timelineElements.isEmpty()) {
            JPanel timelineEmptyPanel = new JPanel(new GridBagLayout());
            timelineEmptyPanel.setBackground(new Color(202, 240, 248));

            JLabel timelineEmpty = new JLabel("Your trip timeline is empty");
            timelineEmpty.setFont(new Font("Segoe UI", Font.BOLD, 14));
            timelineEmpty.setForeground(new Color(3, 4, 94));

            timelineEmptyPanel.add(timelineEmpty);
            timelinePanel.add(timelineEmptyPanel);
        }

        for (Object element : timelineElements) {
            String[] parts = element.toString().split(", ", 3);
            String titleAndDate = parts[0] + ", " + parts[1];
            String details = parts.length > 2 ? parts[2] : "";

            RoundedPanel itemPanel = new RoundedPanel(25);
            itemPanel.setLayout(new GridBagLayout());
            itemPanel.setBackground(Color.WHITE);
            itemPanel.setPreferredSize(new Dimension(300, 60));
            itemPanel.setMaximumSize(new Dimension(300, 60));

            JLabel titleLabel = new JLabel(titleAndDate, SwingConstants.CENTER);
            titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));

            JLabel detailsLabel = new JLabel(details, SwingConstants.CENTER);
            detailsLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));

            JPanel textPanel = new JPanel();
            textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS));
            textPanel.setOpaque(false);

            titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            detailsLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

            textPanel.add(titleLabel);
            textPanel.add(detailsLabel);

            itemPanel.add(textPanel);
            timelinePanel.add(itemPanel);

            timelinePanel.add(Box.createVerticalStrut(20));
        }

        System.out.println("Éléments de la timeline : " + timelineElements);

        SwingUtilities.invokeLater(() -> {
            timelinePanel.revalidate();
            timelinePanel.repaint();
        });
    }
}
