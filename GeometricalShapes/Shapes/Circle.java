package GeometricalShapes.Shapes;

import java.awt.Color;
import java.util.Random;

import GeometricalShapes.Displayable;
import GeometricalShapes.Drawable;

public class Circle implements Drawable{
    private final Point center;
    private final int radius;
    private final Color color;

    // Constructor
    public Circle(Point center, int radius){
        this.center = center;
        this.radius = radius;
        this.color = randomColor();
    }

    // Random Color
    private Color randomColor(){
        Random rndNumber = new Random();
        return new Color(rndNumber.nextInt(256), rndNumber.nextInt(256), rndNumber.nextInt(256));
    }

    // Getters
    public Point getCenter() { return this.center; }
    public int getRadius() {return this.radius;}
    @Override // Get Color
    public Color getColor() { return color; }

    // Draw
    @Override
    public void draw(Displayable displayable) {
        int cx = center.getX();
        int cy = center.getY();
        int r = radius;

        int offsetX = 0;
        int offsetY = -r;

        while (offsetX < -offsetY) {
            float midpointY = offsetY + 0.5f;

            if ((offsetX * offsetX) + (midpointY * midpointY) > (r * r)) {
                offsetY += 1;
            }

            // 8 octants of the circle
            displayable.display(cx + offsetX, cy + offsetY, color); // top right
            displayable.display(cx - offsetX, cy + offsetY, color); // top left
            displayable.display(cx - offsetX, cy - offsetY, color); // bottom left
            displayable.display(cx + offsetX, cy - offsetY, color); // bottom right

            displayable.display(cx - offsetY, cy - offsetX, color); // right top
            displayable.display(cx - offsetY, cy + offsetX, color); // right bottom
            displayable.display(cx + offsetY, cy - offsetX, color); // left top
            displayable.display(cx + offsetY, cy + offsetX, color); // left bottom

            offsetX += 1;
        }
    }
}
