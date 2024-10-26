import pt.ipoo.filters.ImageDisplay;
import pt.ipoo.filters.PixelProcessor;

public class EmptyFilter {
    public static void main(String[] args) {

        PixelProcessor filter = new PixelProcessor() {
            @Override
            public void processPixels(int[][][] image) {
                // Your code here
            }
        };

        // Create an instance of the pt.ipoo.filters.ImageDisplay class, passing the pixel processor
        new ImageDisplay(filter);
    }
}
