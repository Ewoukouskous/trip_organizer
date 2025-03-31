package fr.ynov.gui.tripEditor;

import fr.ynov.gui.Button;
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
        setSize(400, 350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        getContentPane().setBackground(new Color(202, 240, 248));
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel titleLabel = new JLabel("Ajouter un Hébergement", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2;
        add(titleLabel, gbc);

        gbc.gridwidth = 1;
        gbc.gridy++;
        add(new JLabel("Type d'Hébergement :"), gbc);
        accomodationTypeComboBox = new JComboBox<>(new String[]{"Hôtel", "Airbnb"});
        gbc.gridx = 1;
        add(accomodationTypeComboBox, gbc);

        gbc.gridx = 0; gbc.gridy++;
        add(new JLabel("Prix (€) :"), gbc);
        priceField = new JTextField();
        gbc.gridx = 1;
        add(priceField, gbc);

        gbc.gridx = 0; gbc.gridy++;
        add(new JLabel("Adresse :"), gbc);
        addressField = new JTextField();
        gbc.gridx = 1;
        add(addressField, gbc);

        gbc.gridx = 0; gbc.gridy++;
        add(new JLabel("Date Début (YYYY-MM-DD) :"), gbc);
        beginDateField = new JTextField();
        gbc.gridx = 1;
        add(beginDateField, gbc);

        gbc.gridx = 0; gbc.gridy++;
        add(new JLabel("Date Fin (YYYY-MM-DD) :"), gbc);
        endDateField = new JTextField();
        gbc.gridx = 1;
        add(endDateField, gbc);

        addButton = new Button("Ajouter Hébergement");
        addButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
        addButton.setBackground(new Color(0, 123, 255));
        addButton.setForeground(Color.WHITE);
        addButton.setFocusPainted(false);
        addButton.addActionListener(e -> addAccomodation());

        gbc.gridx = 0; gbc.gridy++;
        gbc.gridwidth = 2;
        add(addButton, gbc);

        setVisible(true);
    }

    private void addAccomodation() {
        try {
            String selectedType = (String) accomodationTypeComboBox.getSelectedItem();
            int price = Integer.parseInt(priceField.getText());
            String address = addressField.getText();
            LocalDate beginDate = LocalDate.parse(beginDateField.getText());
            LocalDate endDate = LocalDate.parse(endDateField.getText());

            if (beginDate.isAfter(endDate)) {
                JOptionPane.showMessageDialog(this, "Erreur : La date de début doit être avant la date de fin !", "Erreur", JOptionPane.ERROR_MESSAGE);
                return;
            }

            assert selectedType != null;
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
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Erreur : Prix invalide !", "Erreur", JOptionPane.ERROR_MESSAGE);
        } catch (DateTimeParseException e) {
            JOptionPane.showMessageDialog(this, "Erreur : Format de date incorrect ! (YYYY-MM-DD)", "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }
}
