package fr.ynov.gui;

import fr.ynov.models.Trip;
import fr.ynov.models.activities.*;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class ActivityEditorFrame extends JFrame {
    private Trip trip;
    private JComboBox<String> activityTypeComboBox;
    private JTextField nameField;
    private JTextField cityField;
    private JTextField priceField;
    private JTextField dateField;
    private JButton addButton;

    public ActivityEditorFrame(Trip trip) {
        this.trip = trip;

        setTitle("Ajouter une Activité");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(6, 2, 10, 10));

        // ComboBox avec les types d'activités
        String[] activityTypes = {"Sport", "Visite", "Divertissement"};
        activityTypeComboBox = new JComboBox<>(activityTypes);

        // Champs de saisie pour l'activité
        nameField = new JTextField();
        cityField = new JTextField();
        priceField = new JTextField();
        dateField = new JTextField();

        addButton = new JButton("Ajouter Activité");
        addButton.addActionListener(e -> addActivity());

        // Ajout des composants à la JFrame
        add(new JLabel("Type d'Activité :"));
        add(activityTypeComboBox);
        add(new JLabel("Nom :"));
        add(nameField);
        add(new JLabel("Ville :"));
        add(cityField);
        add(new JLabel("Prix (€) :"));
        add(priceField);
        add(new JLabel("Date (YYYY-MM-DD) :"));
        add(dateField);
        add(new JLabel()); // Espace vide
        add(addButton);

        setVisible(true);
    }

    private void addActivity() {
        String selectedType = (String) activityTypeComboBox.getSelectedItem();
        String name = nameField.getText();
        String city = cityField.getText();
        String priceText = priceField.getText();
        String dateText = dateField.getText();

        try {
            int price = Integer.parseInt(priceText);
            LocalDate date = LocalDate.parse(dateText);

            if (selectedType != null) {
                Activities activity = switch (selectedType) {
                    case "Sport" -> new Sport(1, name, city, price, date);
                    case "Visite" -> new Visit(1, name, city, price, date);
                    case "Divertissement" -> new Entertainement(1, name, city, price, date);
                    default -> null;
                };

                if (activity != null) {
                    trip.getActivitiesList().add(activity);
                    JOptionPane.showMessageDialog(this, "Activité ajoutée avec succès !");
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
