package fr.ynov.gui.tripEditor;

import fr.ynov.gui.utils.Button;
import fr.ynov.models.Trip;
import fr.ynov.models.transport.*;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class TransportEditorFrame extends JFrame {
    private final Trip trip;
    private final JComboBox<String> transportTypeComboBox;
    private final JTextField priceField;
    private final JTextField dateField;

    // Constructor of the Frame
    public TransportEditorFrame(Trip trip) {
        this.trip = trip;

        setTitle("Ajouter un Transport");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        getContentPane().setBackground(new Color(202, 240, 248));
        setLayout(new GridBagLayout());

        // The GridBagConstraints will define the margin of an element
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Creation of the component for the frame

        JLabel titleLabel = new JLabel("Ajouter un Transport", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
            // define some parameter for the margin
                // gridx is for the column where the component will be placed
                // gridy for the line
                // and gridwidth for the number of column
        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2;
        add(titleLabel, gbc);

        gbc.gridwidth = 1;
        gbc.gridy++;
        add(new JLabel("Type de transport :"), gbc);
        transportTypeComboBox = new JComboBox<>(new String[]{"Voiture", "Train", "Avion", "Bateau"});
        gbc.gridx = 1;
        add(transportTypeComboBox, gbc);

        gbc.gridx = 0; gbc.gridy++;
        add(new JLabel("Prix (€) :"), gbc);
        priceField = new JTextField();
        gbc.gridx = 1;
        add(priceField, gbc);

        gbc.gridx = 0; gbc.gridy++;
        add(new JLabel("Date (YYYY-MM-DD) :"), gbc);
        dateField = new JTextField();
        gbc.gridx = 1;
        add(dateField, gbc);

        JButton addButton = new Button("Ajouter Transport");
        addButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
        addButton.setBackground(new Color(0, 123, 255));
        addButton.setForeground(Color.WHITE);
        addButton.setFocusPainted(false);
        addButton.addActionListener(e -> addTransport());

        gbc.gridx = 0; gbc.gridy++;
        gbc.gridwidth = 2;
        add(addButton, gbc);

        setVisible(true);
    }

    // Get all the parameters entered in the text fields for the creation of a transportType
    private void addTransport() {
        try {
            // get the parameters
            String selectedType = (String) transportTypeComboBox.getSelectedItem();
            int price = Integer.parseInt(priceField.getText());
            LocalDate date = LocalDate.parse(dateField.getText());

            // Create the object with the parameters obtained
            assert selectedType != null;
            TransportType transport = switch (selectedType) {
                case "Voiture" -> new Car(1, price, date);
                case "Train" -> new Train(1, price, date);
                case "Avion" -> new Plane(1, price, date);
                case "Bateau" -> new Boat(1, price, date);
                default -> null;
            };

            // Add the object to the trip selected
            if (transport != null) {
                trip.addTransportType(transport);
                JOptionPane.showMessageDialog(this, "Transport ajouté avec succès !");
                dispose();
            }

            // If there's an error we catch it and display it in an error message
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Erreur : Prix invalide !", "Erreur", JOptionPane.ERROR_MESSAGE);
        } catch (DateTimeParseException e) {
            JOptionPane.showMessageDialog(this, "Erreur : Format de date incorrect ! (YYYY-MM-DD)", "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }
}
