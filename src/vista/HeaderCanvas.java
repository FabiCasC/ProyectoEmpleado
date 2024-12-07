/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import java.awt.*;
import java.awt.image.BufferedImage;

public class HeaderCanvas extends Canvas {
    private final BufferedImage logoImage;
    private final String title;

    public HeaderCanvas(String title) {
        this.title = title;
        setBackground(new Color(50, 50, 50));
        setForeground(Color.WHITE);
        setFont(new Font("Arial", Font.BOLD, 24));

        //Imagen
        logoImage = createLogoImage();
    }

    private BufferedImage createLogoImage() {
        BufferedImage img = new BufferedImage(50, 50, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = img.createGraphics();
        g2d.setColor(new Color(100, 149, 237));
        g2d.fillOval(0, 0, 50, 50);
        g2d.setColor(Color.WHITE);
        g2d.setFont(new Font("Arial", Font.BOLD, 30));
        g2d.drawString("P", 15, 35);
        g2d.dispose();
        return img;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Draw logo
        g2d.drawImage(logoImage, 20, 10, this);

        // Draw title
        g2d.setFont(getFont());
        FontMetrics fm = g2d.getFontMetrics();
        int titleWidth = fm.stringWidth(title);
        int titleX = (getWidth() - titleWidth) / 2;
        g2d.drawString(title, titleX, 40);

        // Draw a decorative line
        g2d.setStroke(new BasicStroke(2));
        g2d.drawLine(0, getHeight() - 2, getWidth(), getHeight() - 2);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(super.getPreferredSize().width, 60);
    }
}

