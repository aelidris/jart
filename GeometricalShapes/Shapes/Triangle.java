package GeometricalShapes.Shapes;

import GeometricalShapes.*;
import java.awt.Color;
import java.util.Random;

public class Triangle implements Drawable {
    private Point a;
    private Point b;
    private Point c;
    private Color color;

    public Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.color = randomColor();
    }

    // Random Color
    private Color randomColor(){
        Random rndNumber = new Random();
        return new Color(rndNumber.nextInt(256), rndNumber.nextInt(256), rndNumber.nextInt(256));
    }

    public Point getA() {
        return a;
    }

    public Point getB() {
        return b;
    }

    public Point getC() {
        return c;
    }

    public Color getColor() {
        return color;
    }

    public void draw(Displayable displayable) {
        Line ab = new Line(a, b, color);
        Line bc = new Line(b, c, color);
        Line ca = new Line(c, a, color);

        ab.draw(displayable);
        bc.draw(displayable);
        ca.draw(displayable);
    }
}