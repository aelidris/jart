package GeometricalShapes.Shapes;


import java.awt.Color;
import java.util.Random;
import GeometricalShapes.Displayable;

public class Pentagon {
    private Point[] p5;
    private Line[] lines5;
    private Color clr;

    public Pentagon(Point ctr, int r) {
        this.lines5 = new Line[5];
        this.p5 = new Point[5];
        this.clr = randomColor();
        double angle = 2 * Math.PI / 5;
        //generate all 5 cord
        for (int i = 0; i< 5; i++) {
            double tht = i * angle - Math.PI / 2;
            this.p5[i] = new Point((int)(ctr.x + r * Math.cos(tht)), (int)(ctr.y + r * Math.sin(tht)));
        }
        this.lines5[0] = new Line(this.p5[0],this.p5[1]);
        this.lines5[1] = new Line(this.p5[1],this.p5[2]);
        this.lines5[2] = new Line(this.p5[2],this.p5[3]);
        this.lines5[3] = new Line(this.p5[3],this.p5[4]);
        this.lines5[4] = new Line(this.p5[4],this.p5[0]);
    }

    public void Draw(Displayable displayable) {
        for (int i = 0;i<5;i++) {
            this.lines5[i].color = this.clr;
            this.lines5[i].draw(displayable);
        }
    }

    private Color randomColor(){
        Random rndNumber = new Random();
        return new Color(rndNumber.nextInt(256), rndNumber.nextInt(256), rndNumber.nextInt(256));
    }
}
