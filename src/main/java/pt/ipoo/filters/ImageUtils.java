package pt.ipoo.filters;

import java.awt.image.BufferedImage;

public class ImageUtils {

    public static int[][][] convertToArray(BufferedImage image) {
        int width = image.getWidth();
        int height = image.getHeight();
        int[][][] result = new int[width][height][4]; // [R, G, B, A]

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int rgba = image.getRGB(x, y);
                result[x][y][0] = (rgba >> 16) & 0xFF; // Red
                result[x][y][1] = (rgba >> 8) & 0xFF;  // Green
                result[x][y][2] = rgba & 0xFF;         // Blue
                result[x][y][3] = (rgba >> 24) & 0xFF; // Alpha
            }
        }

        return result;
    }

    public static BufferedImage convertToBufferedImage(int[][][] array) {
        int width = array.length;
        int height = array[0].length;
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int r = array[x][y][0];
                int g = array[x][y][1];
                int b = array[x][y][2];
                int a = array[x][y][3];
                int rgba = (a << 24) | (r << 16) | (g << 8) | b;
                image.setRGB(x, y, rgba);
            }
        }

        return image;
    }
}
