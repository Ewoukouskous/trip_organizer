package fr.ynov.gui;

import fr.ynov.models.Trip;
import fr.ynov.models.transport.*;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class TransportEditorFrame extends JFrame {
    private Trip trip;
    private JComboBox<String> transportTypeComboBox;
    private JTextField priceField;
    private JTextField dateField;
    private JButton addButton;

    public TransportEditorFrame(Trip trip) {
        this.trip = trip;

        setTitle("Ajouter un Transport");
        setSize(350, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(4, 2, 10, 10));

        // ComboBox avec les types de transport
        String[] transportTypes = {"Voiture", "Train", "Avion", "Bateau"};
        transportTypeComboBox = new JComboBox<>(transportTypes);

        // Champs pour le prix et la date
        priceField = new JTextField();
        dateField = new JTextField();

        addButton = new JButton("Ajouter Transport");
        addButton.addActionListener(e -> addTransport());

        // Ajout des composants à la JFrame
        add(new JLabel("Type de transport :"));
        add(transportTypeComboBox);
        add(new JLabel("Prix (€) :"));
        add(priceField);
        add(new JLabel("Date (YYYY-MM-DD) :"));
        add(dateField);
        add(new JLabel()); // Espace vide
        add(addButton);

        setVisible(true);
    }

    private void addTransport() {
        String selectedType = (String) transportTypeComboBox.getSelectedItem();
        String priceText = priceField.getText();
        String dateText = dateField.getText();

        try {
            int price = Integer.parseInt(priceText);
            LocalDate date = LocalDate.parse(dateText);

            if (selectedType != null) {
                TransportType transport = switch (selectedType) {
                    case "Voiture" -> new Car(1, price, date);
                    case "Train" -> new Train(1, price, date);
                    case "Avion" -> new Plane(1, price, date);
                    case "Bateau" -> new Boat(1, price, date);
                    default -> null;
                };

                if (transport != null) {
                    trip.addTransportType(transport);
                    JOptionPane.showMessageDialog(this, "Transport ajouté avec succès !");
                    dispose();
                }
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Erreur : Prix invalide !", "Erreur", JOptionPane.ERROR_MESSAGE);
        } catch (DateTimeParseException e) {
            JOptionPane.showMessageDialog(this, "Erreur : Format de date incorrect ! (YYYY-MM-DD)", "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }
}
