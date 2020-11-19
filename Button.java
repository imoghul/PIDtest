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
            if (beganIn && Main.mouseOccupied.isClear()) {
                Main.mouseOccupied = this;
            }
            if (Main.mouseOccupied == this) {
                return beganIn;
            } else {
                return false;
            }
        } else {
            beganIn = false;
            return false;
        }
    }

    public boolean isPressed(Point p) {
        return isPressed(p.getX(), p.getY());
    }

    public boolean isClear() {
        return getX() == 0 && getY() == 0 && getW() == 0 && getH() == 0;
    }
}