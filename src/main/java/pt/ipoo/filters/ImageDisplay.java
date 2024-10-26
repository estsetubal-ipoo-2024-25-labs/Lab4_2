package pt.ipoo.filters;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ImageDisplay extends JFrame {

    private BufferedImage img;

    public ImageDisplay(PixelProcessor processor) {
        try {
            // Load the image
            img = ImageIO.read(new File("Lenna.png"));

            // Convert to 3D array
            int[][][] imageArray = ImageUtils.convertToArray(img);

            // Apply the pixel processing operation
            processor.processPixels(imageArray);

            // Convert back to BufferedImage
            img = ImageUtils.convertToBufferedImage(imageArray);

        } catch (IOException e) {
            e.printStackTrace();
        }

        // Set the window size to match the image size
        setSize(img.getWidth(), img.getHeight());

        // Set the window title
        setTitle("IPOO | Image Processing");

        // Ensure the application exits when the window is closed
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Center window
        setLocationRelativeTo(null);

        // Make the window visible
        setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        // Draw the image on the window
        g.drawImage(img, 0, 0, null);
    }

    private static int clamp(int value) {
        return Math.max(0, Math.min(255, value));
    }
}