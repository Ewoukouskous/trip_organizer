package fr.ynov.gui;

import fr.ynov.models.Trip;
import fr.ynov.models.accomodation.*;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class AccomodationEditorFrame extends JFrame {
    private Trip trip;
    private JComboBox<String> accomodationTypeComboBox;
    private JTextField priceField;
    private JTextField addressField;
    private JTextField beginDateField;
    private JTextField endDateField;
    private JButton addButton;

    public AccomodationEditorFrame(Trip trip) {
        this.trip = trip;

        setTitle("Ajouter un Hébergement");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(6, 2, 10, 10));

        // ComboBox pour choisir le type d'hébergement
        String[] accomodationTypes = {"Hôtel", "Airbnb"};
        accomodationTypeComboBox = new JComboBox<>(accomodationTypes);

        // Champs de saisie
        priceField = new JTextField();
        addressField = new JTextField();
        beginDateField = new JTextField();
        endDateField = new JTextField();

        addButton = new JButton("Ajouter Hébergement");
        addButton.addActionListener(e -> addAccomodation());

        // Ajout des composants à la JFrame
        add(new JLabel("Type d'Hébergement :"));
        add(accomodationTypeComboBox);
        add(new JLabel("Prix (€) :"));
        add(priceField);
        add(new JLabel("Adresse :"));
        add(addressField);
        add(new JLabel("Date Début (YYYY-MM-DD) :"));
        add(beginDateField);
        add(new JLabel("Date Fin (YYYY-MM-DD) :"));
        add(endDateField);
        add(new JLabel()); // Espace vide
        add(addButton);

        setVisible(true);
    }

    private void addAccomodation() {
        String selectedType = (String) accomodationTypeComboBox.getSelectedItem();
        String priceText = priceField.getText();
        String address = addressField.getText();
        String beginDateText = beginDateField.getText();
        String endDateText = endDateField.getText();

        try {
            int price = Integer.parseInt(priceText);
            LocalDate beginDate = LocalDate.parse(beginDateText);
            LocalDate endDate = LocalDate.parse(endDateText);

            if (beginDate.isAfter(endDate)) {
                JOptionPane.showMessageDialog(this, "Erreur : La date de début doit être avant la date de fin !", "Erreur", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (selectedType != null) {
                Accomodation accomodation = switch (selectedType) {
                    case "Hôtel" -> new Hostel(price, address, beginDate, endDate);
                    case "Airbnb" -> new Airbnb(price, address, beginDate, endDate);
                    default -> null;
                };

                if (accomodation != null) {
                    trip.getAccomodationsList().add(accomodation);
                    JOptionPane.showMessageDialog(this, "Hébergement ajouté avec succès !");
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
