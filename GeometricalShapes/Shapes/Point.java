package GeometricalShapes.Shapes;

import GeometricalShapes.Displayable;
import GeometricalShapes.Drawable;
import java.awt.Color;
import java.util.Random;

public class Point implements Drawable {

    public final int x;
    public final int y;
    private final Color color;

    public Point(int x, int y){
        this.x = x;
        this.y = y;
        this.color = getColor();
    }

    public Point() {
        Random random = new Random();
        x = random.nextInt(1001);
        y = random.nextInt(1001);
        color = randomColor();
    }

    @Override
    public void draw(Displayable displayable){
        displayable.display(x, y, color);
    }

    @Override
    public Color getColor(){
        // return this.color;
        Random rndNumber = new Random();
        int r = rndNumber.nextInt(256);
        int g = rndNumber.nextInt(256);
        int b = rndNumber.nextInt(256);
        Color color = new Color(r, g, b);
        return color;
    }

    private Color randomColor(){
        Random rndNumber = new Random();
        return new Color(rndNumber.nextInt(256), rndNumber.nextInt(256), rndNumber.nextInt(256));
    }
    // create random point
    public static Point random(int width, int height){
        Random rndNumber = new Random();
        int x = rndNumber.nextInt(width);
        int y = rndNumber.nextInt(height);
        return new Point(x, y);
    }

    //Getters
    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }

    
}
