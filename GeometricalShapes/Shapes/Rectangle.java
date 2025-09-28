package GeometricalShapes.Shapes;

import GeometricalShapes.*;
import java.awt.Color;
import java.util.Random;

public class Rectangle implements Drawable {
    private Point topLeft;
    private Point bottomRight;
    private Color color;

    public Rectangle(Point topLeft, Point bottomRight) {
        this.topLeft = topLeft;
        this.bottomRight = bottomRight;
        this.color = randomColor();
    }

    // Random Color
    private Color randomColor(){
        Random rndNumber = new Random();
        return new Color(rndNumber.nextInt(256), rndNumber.nextInt(256), rndNumber.nextInt(256));
    }

    public Point getTopLeft() {
        return topLeft;
    }

    public Point getBottomRight() {
        return bottomRight;
    }

    public Color getColor() {
        return color;
    }

    public void draw(Displayable displayable) {
        int x1 = topLeft.getX();
        int y1 = topLeft.getY();
        int x2 = bottomRight.getX();
        int y2 = bottomRight.getY();

        Point topRight = new Point(x2, y1);
        Point bottomLeft = new Point(x1, y2);

        Line top = new Line(topLeft, topRight, color);
        Line right = new Line(topRight, bottomRight, color);
        Line bottom = new Line(bottomRight, bottomLeft, color);
        Line left = new Line(topLeft, bottomLeft, color);

        top.draw(displayable);
        right.draw(displayable);
        bottom.draw(displayable);
        left.draw(displayable);
    }
}
