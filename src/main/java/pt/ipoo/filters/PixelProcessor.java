package pt.ipoo.filters;

public interface PixelProcessor {
    /**
     * Processes a 3D array of pixel values representing an image.
     * <p>
     * The image is represented as a 3-dimensional array, where:
     * <ul>
     *   <li>The first dimension represents the columns (width) of the image.</li>
     *   <li>The second dimension represents the rows (height) of the image.</li>
     *   <li>The third dimension represents the color channels (RGB).</li>
     * </ul>
     * Each pixel is thus defined by three color values (e.g., red, green, and blue).
     *
     * @param image a 3D integer array representing the image, where {@code image[col][row][channel]}
     *              corresponds to the color channel value of the pixel at row {@code row}
     *              and column {@code col}.
     */
    void processPixels(int[][][] image);
}
