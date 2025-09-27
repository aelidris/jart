package GeometricalShapes.Shapes;

import java.util.Random;

import GeometricalShapes.Displayable;
import GeometricalShapes.Drawable;

import java.awt.Color;

public class Line implements Drawable {
    private final Point start;
    private final Point end;
    private final Color color;

    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
        this.color = randomColor();
    }

    // Random Color
    private Color randomColor() {
        return Color.WHITE;
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

    // Random Line
    public static Line random(int width, int height) {
        Point p1 = Point.random(width, height);
        Point p2 = Point.random(width, height);

        return new Line(p1, p2);
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
