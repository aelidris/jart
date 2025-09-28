package GeometricalShapes.Shapes;

import java.awt.Color;
import java.util.Random;

import GeometricalShapes.Displayable;
import GeometricalShapes.Drawable;

public class Cube implements Drawable {
    private Point center;
    private int size;
    private Color color;
    
    // Constructor
    public Cube(Point center, int size) {
        this.center = center;
        this.size = size;
        this.color = randomColor();
    }

     private Color randomColor(){
        Random rndNumber = new Random();
        return new Color(rndNumber.nextInt(256), rndNumber.nextInt(256), rndNumber.nextInt(256));
    }
    
    @Override
    public void draw(Displayable displayable) {
        int cx = center.getX();
        int cy = center.getY();
        int halfSize = size / 2;
        
        // Front face vertices
        Point frontTopLeft = new Point(cx - halfSize, cy - halfSize);
        Point frontTopRight = new Point(cx + halfSize, cy - halfSize);
        Point frontBottomLeft = new Point(cx - halfSize, cy + halfSize);
        Point frontBottomRight = new Point(cx + halfSize, cy + halfSize);
        
        // Back face vertices
        int offset = size / 4;
        Point backTopLeft = new Point(cx - halfSize + offset, cy - halfSize - offset);
        Point backTopRight = new Point(cx + halfSize + offset, cy - halfSize - offset);
        Point backBottomLeft = new Point(cx - halfSize + offset, cy + halfSize - offset);
        Point backBottomRight = new Point(cx + halfSize + offset, cy + halfSize - offset);
        
        // Draw front face
        drawRectangleWithColor(displayable, frontTopLeft, frontBottomRight);
        
        // Draw back face
        drawRectangleWithColor(displayable, backTopLeft, backBottomRight);
        
        // Draw connecting edges
        Line edge1 = new Line(frontTopLeft, backTopLeft, color);
        Line edge2 = new Line(frontTopRight, backTopRight, color);
        Line edge3 = new Line(frontBottomLeft, backBottomLeft, color);
        Line edge4 = new Line(frontBottomRight, backBottomRight, color);
        
        edge1.draw(displayable);
        edge2.draw(displayable);
        edge3.draw(displayable);
        edge4.draw(displayable);
    }
    
    private void drawRectangleWithColor(Displayable displayable, Point topLeft, Point bottomRight) {
        Point topRight = new Point(bottomRight.getX(), topLeft.getY());
        Point bottomLeft = new Point(topLeft.getX(), bottomRight.getY());
        
        Line top = new Line(topLeft, topRight, color);
        Line right = new Line(topRight, bottomRight, color);
        Line bottom = new Line(bottomRight, bottomLeft, color);
        Line left = new Line(bottomLeft, topLeft, color);
        
        top.draw(displayable);
        right.draw(displayable);
        bottom.draw(displayable);
        left.draw(displayable);
    }
    
    @Override
    public Color getColor() {
        return color;
    }
    
    // Getters
    public Point getCenter() { return center; }
    public int getSize() { return size; }
}