import java.awt.*;

public class Button extends Drawer {
    Collision checker = new Collision();
    boolean beganIn = false;
    private double mouseX, mouseY;

    public Button(double x, double y, double w, double h) {
        super(x, y, w, h);
    }

    public boolean isPressed(double x, double y) {
        mouseX = x;
        mouseY = y;
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

    public void drawState(Graphics g, Color unpressed, Color pressed, boolean filled, boolean filledPressed,
            String type, double mX, double mY) {
        if (!this.isPressed(mX, mY)) {
            draw(g, unpressed, filled, type);
        } else {
            draw(g, pressed, filledPressed, type);
        }
    }

    public boolean isPressed(Point p) {
        return isPressed(p.getX(), p.getY());
    }

    private boolean isClear() {
        return getX() == 0 && getY() == 0 && getW() == 0 && getH() == 0;
    }
}