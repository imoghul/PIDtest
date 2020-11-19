import java.awt.Point;

public class Button extends Drawer {
    Collision checker = new Collision();

    boolean beganIn = false;

    public Button(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4) {
        super(paramDouble1, paramDouble2, paramDouble3, paramDouble4);
    }

    public boolean isPressed(double paramDouble1, double paramDouble2) {
        if (Main.mousePressed) {
            if (!this.beganIn)
                this.beganIn = this.checker.autoIsIn(paramDouble1, paramDouble2, this);
            return this.beganIn;
        }
        this.beganIn = false;
        return false;
    }

    public boolean isPressed(Point paramPoint) {
        return isPressed(paramPoint.getX(), paramPoint.getY());
    }
}
