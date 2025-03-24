package fr.ynov.gui;

import javax.swing.*;
import java.awt.*;

public class RoundButton extends JButton {
    public RoundButton(String text) {
        super(text);
        setContentAreaFilled(false);
        setFocusPainted(false);
        setBorderPainted(false);
        setPreferredSize(new Dimension(70, 70)); // Taille du bouton
    }

    @Override
    protected void paintComponent(Graphics g) {
        if (getModel().isArmed()) {
            g.setColor(getBackground().darker());
        } else {
            g.setColor(getBackground());
        }
        g.fillOval(0, 0, getWidth(), getHeight());
        super.paintComponent(g);
    }

    @Override
    protected void paintBorder(Graphics g) {
        g.setColor(getForeground());
        g.drawOval(0, 0, getWidth() - 1, getHeight() - 1);
    }

    @Override
    public boolean contains(int x, int y) {
        int radius = getWidth() / 2;
        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;
        return ((x - centerX) * (x - centerX) + (y - centerY) * (y - centerY)) <= radius * radius;
    }
}