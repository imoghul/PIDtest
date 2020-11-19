import java.awt.*;

public class Button extends Drawer {
    Collision checker = new Collision();
    boolean beganIn = false;

    public Button(double x, double y, double w, double h) {
        super(x, y, w, h);
    }

    public boolean isPressed(double x, double y) {
        // return Main.mousePressed && checker.autoIsIn(x, y, this);
        if (Main.mousePressed) {
            if (beganIn == false) {
                beganIn = checker.autoIsIn(x, y, this);
            }
            return beganIn;
        } else {
            beganIn = false;
            return false;
        }
    }

    public boolean isPressed(Point p) {
        return isPressed(p.getX(), p.getY());
    }
}