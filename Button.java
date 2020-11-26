import java.awt.*;

public class Button extends Drawer {
    Collision checker = new Collision();
    boolean wasIn = false;
    private double mouseX, mouseY;

    public Button(double x, double y, double w, double h) {
        super(x, y, w, h);
    }

    public boolean isPressed(double x, double y) {
        mouseX = x;
        mouseY = y;
        boolean beganIn = (checker.autoIsIn(Main.mouseXOrig, Main.mouseYOrig, this)
                || checker.autoIsIn(Main.mouseXOrig, Main.mouseYOrig, getMidBar()));
        if (Main.mousePressed) {
            if (wasIn == false) {
                wasIn = checker.autoIsIn(x, y, this) || checker.autoIsIn(x, y, getMidBar());
            }
            if (wasIn && Main.mouseOccupied.isClear()) {
                Main.mouseOccupied = this;
            }
            if (Main.mouseOccupied == this) {
                return wasIn;
            } else {
                return false;
            }
        } else {
            wasIn = false;
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

    public Drawer getMidBar() {
        return this;
    }
}