package fr.ynov.gui;

import javax.swing.*;
import java.awt.*;

class RoundedBottomPanel extends JPanel {
    private int cornerRadius;

    public RoundedBottomPanel(int radius) {
        this.cornerRadius = radius;
        setOpaque(false); // Fond transparent
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());

        int width = getWidth();
        int height = getHeight();

        g2.fillRect(0, 0, width, height - cornerRadius);

        g2.fillArc(0, height - cornerRadius * 2, cornerRadius * 2, cornerRadius * 2, 180, 90);
        g2.fillArc(width - cornerRadius * 2, height - cornerRadius * 2, cornerRadius * 2, cornerRadius * 2, 270, 90);

        g2.fillRect(cornerRadius, height - cornerRadius, width - cornerRadius * 2, cornerRadius);
    }

}
