import Graphics.ShapeImplementation;
import Graphics.Shape;
import Graphics.Mouse;
import java.awt.Color;

public class Sprite extends ShapeImplementation {
    public int colorCounter = 0;
    public Color spriteColor = Color.red;

    public Sprite(Shape s) {
        super(s);
    }

    @Override
    public void update(Mouse m) {
        setMinX(0);
        setMinY(0);
        setMaxX(Main.displayW - getW() / 2.0);
        setMaxY(Main.displayH - getH() / 2.0);
        colorCounter++;

        if (xcontroller.hasReached(getX(), m.getX()) && ycontroller.hasReached(getY(), m.getY())) {
            spriteColor = new Color(0, 255, 0);
        } else {
            spriteColor = new Color(255, 0, 0, ((colorCounter % 20 + 5)) * 10);// Color.RED;
        }

        setColor(spriteColor);
        setXPID(m.getX());
        setYPID(m.getY());
    }
}