package GeometricalShapes.Rendering;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import GeometricalShapes.*;

public class Image implements Displayable {
    private BufferedImage canvas;
    private int width, height;
    
    public Image(int width, int height) {
        this.width = width;
        this.height = height;
        
        // store an image in RAM
        canvas = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
    }
    
    public void display(int x, int y, Color color) {
        System.out.println("🖼️  Image displayed at (" + x + ", " + y + ")");
    }
    
    public void save(String filename) {
        try {
            if (!filename.endsWith(".png")) {
                filename += ".png";
            } 
            // write an image in file system
            ImageIO.write(canvas, "png", new File(filename));
            System.out.println("🖼️  Image saved: " + filename);
            
        } catch (IOException e) {
            System.err.println("❌ Error saving: " + e.getMessage());
        }
    }
}