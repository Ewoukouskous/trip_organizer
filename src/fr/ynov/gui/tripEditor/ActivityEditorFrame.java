package fr.ynov.gui.tripEditor;

import fr.ynov.gui.Button;
import fr.ynov.models.Trip;
import fr.ynov.models.activities.*;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class ActivityEditorFrame extends JFrame {
    private final Trip trip;
    private final JComboBox<String> activityTypeComboBox;
    private final JTextField nameField;
    private final JTextField cityField;
    private final JTextField priceField;
    private final JTextField dateField;

    public ActivityEditorFrame(Trip trip) {
        this.trip = trip;

        setTitle("Ajouter une Activité");
        setSize(400, 350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        getContentPane().setBackground(new Color(202, 240, 248));
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel titleLabel = new JLabel("Ajouter une Activité", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2;
        add(titleLabel, gbc);

        gbc.gridwidth = 1;
        gbc.gridy++;
        add(new JLabel("Type d'activité :"), gbc);
        activityTypeComboBox = new JComboBox<>(new String[]{"Sport", "Visite", "Divertissement"});
        gbc.gridx = 1;
        add(activityTypeComboBox, gbc);

        gbc.gridx = 0; gbc.gridy++;
        add(new JLabel("Nom :"), gbc);
        nameField = new JTextField();
        gbc.gridx = 1;
        add(nameField, gbc);

        gbc.gridx = 0; gbc.gridy++;
        add(new JLabel("Ville :"), gbc);
        cityField = new JTextField();
        gbc.gridx = 1;
        add(cityField, gbc);

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

        JButton addButton = new Button("Ajouter Activité");
        addButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
        addButton.setBackground(new Color(0, 123, 255));
        addButton.setForeground(Color.WHITE);
        addButton.setFocusPainted(false);
        addButton.addActionListener(e -> addActivity());

        gbc.gridx = 0; gbc.gridy++;
        gbc.gridwidth = 2;
        add(addButton, gbc);

        setVisible(true);
    }

    private void addActivity() {
        try {
            String selectedType = (String) activityTypeComboBox.getSelectedItem();
            String name = nameField.getText();
            String city = cityField.getText();
            int price = Integer.parseInt(priceField.getText());
            LocalDate date = LocalDate.parse(dateField.getText());

            assert selectedType != null;
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
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Erreur : Prix invalide !", "Erreur", JOptionPane.ERROR_MESSAGE);
        } catch (DateTimeParseException e) {
            JOptionPane.showMessageDialog(this, "Erreur : Format de date incorrect ! (YYYY-MM-DD)", "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }
}
