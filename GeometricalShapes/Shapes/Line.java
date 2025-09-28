package GeometricalShapes.Shapes;

import GeometricalShapes.Displayable;
import GeometricalShapes.Drawable;

import java.awt.Color;
import java.util.Random;

public class Line implements Drawable {
    private final Point start;
    private final Point end;
    public Color color;

    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
        this.color = randomColor();
    }

    // Constructor with specified color
    public Line(Point start, Point end, Color color) {
        this.start = start;
        this.end = end;
        this.color = color;
    }

    // Constructor for a random position with a random color
    public Line(int width, int height) {  
        Random random = new Random();
        this.start = new Point(random.nextInt(width), random.nextInt(height));
        this.end = new Point(random.nextInt(width), random.nextInt(height));
        this.color = randomColor();
    }

    private Color randomColor(){
        Random rndNumber = new Random();
        return new Color(rndNumber.nextInt(256), rndNumber.nextInt(256), rndNumber.nextInt(256));
    }

    // Getters
    public Point getStart() {
        return this.start;
    }

    public Point getEnd() {
        return this.end;
    }

    @Override
    public Color getColor() {
        return this.color;
    }

    // Draw
    @Override
    public void draw(Displayable canvas) {
        int startX = start.getX();
        int startY = start.getY();
        int endX = end.getX();
        int endY = end.getY();

        float deltaX = endX - startX;
        float deltaY = endY - startY;

        int totalSteps = (int) Math.max(Math.abs(deltaX), Math.abs(deltaY));

        float stepX = deltaX / totalSteps;
        float stepY = deltaY / totalSteps;

        float currentX = startX;
        float currentY = startY;

        for (int i = 0; i <= totalSteps; i++) {
            canvas.display(Math.round(currentX), Math.round(currentY), color);
            currentX += stepX;
            currentY += stepY;
        }
    }

}
