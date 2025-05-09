package fr.ynov.gui.utils;

import java.awt.*;
import javax.swing.JButton;

public class Button extends JButton {

    private final Color normalColor = new Color(0, 51, 102);
    private final Color hoverColor = new Color(30, 144, 255);
    private boolean isHovered = false;

    public Button(String text) {
        super(text);
        setContentAreaFilled(false);
        setForeground(Color.WHITE);
        setFont(new Font("Segoe UI", Font.BOLD, 14));
        setFocusPainted(false);
        setBorderPainted(false);
        setOpaque(false);

        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                isHovered = true;
                repaint();
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                isHovered = false;
                repaint();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int width = getWidth();
        int height = getHeight();
        int arcSize = 20;

        g2d.setColor(isHovered ? hoverColor : normalColor);
        g2d.fillRoundRect(0, 0, width, height, arcSize, arcSize);

        super.paintComponent(g);
    }
}
