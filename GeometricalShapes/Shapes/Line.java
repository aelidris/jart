package GeometricalShapes.Shapes;

import GeometricalShapes.Displayable;
import GeometricalShapes.Drawable;

import java.awt.Color;
import java.util.Random;

public class Line implements Drawable {
    private final Point start;
    private final Point end;
    private final Color color;

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
    public void draw(Displayable displayable) {
        // Bresenham's line algorithm
        int x1 = start.getX();
        int y1 = start.getY();
        int x2 = end.getX();
        int y2 = end.getY();

        int dx = Math.abs(x2 - x1);
        int dy = Math.abs(y2 - y1);
        int sx = (x1 < x2) ? 1 : -1;
        int sy = (y1 < y2) ? 1 : -1;
        int err = dx - dy;

        while (true) {
            displayable.display(x1, y1, color);
            if (x1 == x2 && y1 == y2)
                break;
            int e2 = 2 * err;
            if (e2 > -dy) {
                err -= dy;
                x1 += sx;
            }
            if (e2 < dx) {
                err += dx;
                y1 += sy;
            }
        }
    }

}
