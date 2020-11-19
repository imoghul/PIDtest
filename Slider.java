import java.awt.Color;
import java.awt.Graphics;

public class Slider extends Button {
    boolean vertical;
    boolean horizontal;
    public double midBarX;
    public double min = 0.0D, max = 1.0D;
    public double midBarY;
    public double midBarW;
    public double midBarH;
    Drawer midBar;

    public Slider(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4,
            boolean paramBoolean1, boolean paramBoolean2, double paramDouble5, double paramDouble6) {
        super(paramDouble1, paramDouble2, paramDouble3, paramDouble4);
        this.min = paramDouble5;
        this.max = paramDouble6;
        if (paramBoolean1 != true || paramBoolean2 != true) {
            this.vertical = paramBoolean1;
            this.horizontal = paramBoolean2;
        }
    }

    public Slider(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4,
            boolean paramBoolean1, boolean paramBoolean2, double paramDouble5, double paramDouble6, double paramDouble7,
            double paramDouble8) {
        this(paramDouble1, paramDouble2, paramDouble3, paramDouble4, paramBoolean1, paramBoolean2, paramDouble7,
                paramDouble8);
        if (this.horizontal) {
            setMinY(paramDouble2);
            setMaxY(paramDouble2);
            setMinX(paramDouble5);
            setMaxX(paramDouble6);
            this.midBarX = paramDouble5;
            this.midBarW = paramDouble6 - paramDouble5;
            this.midBarH = 3.0D;
            this.midBarY = paramDouble2 - ((int) this.midBarH / 2);
        } else if (this.vertical) {
            setMinX(paramDouble1);
            setMaxX(paramDouble1);
            setMinY(paramDouble5);
            setMaxY(paramDouble6);
            this.midBarY = paramDouble5;
            this.midBarH = paramDouble6 - paramDouble5;
            this.midBarW = 3.0D;
            this.midBarX = paramDouble1 - ((int) this.midBarW / 2);
        }
        this.midBar = new Drawer(this.midBarX, this.midBarY, this.midBarW, this.midBarH);
    }

    public Slider(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4,
            boolean paramBoolean1, boolean paramBoolean2, double paramDouble5, double paramDouble6, double paramDouble7,
            double paramDouble8, double paramDouble9) {
        this(paramDouble1, paramDouble2, paramDouble3, paramDouble4, paramBoolean1, paramBoolean2, paramDouble7,
                paramDouble8);
        if (this.horizontal) {
            setMinY(paramDouble2);
            setMaxY(paramDouble2);
            setMinX(paramDouble5);
            setMaxX(paramDouble6);
            this.midBarX = paramDouble5;
            this.midBarW = paramDouble6 - paramDouble5;
            this.midBarH = 3.0D;
            this.midBarY = paramDouble2 - ((int) this.midBarH / 2);
        } else if (this.vertical) {
            setMinX(paramDouble1);
            setMaxX(paramDouble1);
            setMinY(paramDouble5);
            setMaxY(paramDouble6);
            this.midBarY = paramDouble5;
            this.midBarH = paramDouble6 - paramDouble5;
            this.midBarW = 3.0D;
            this.midBarX = paramDouble1 - ((int) this.midBarW / 2);
        }
        setVal(paramDouble9);
        this.midBar = new Drawer(this.midBarX, this.midBarY, this.midBarW, this.midBarH);
    }

    private void updateMidBar() {
        if (this.horizontal) {
            this.midBarX = getMinX();
            this.midBarW = getMaxX() - getMinX();
            this.midBarH = 3.0D;
            this.midBarY = getY() - ((int) this.midBarH / 2);
        } else if (this.vertical) {
            this.midBarY = getMinY();
            this.midBarH = getMaxY() - getMinY();
            this.midBarW = 3.0D;
            this.midBarX = getX() - ((int) this.midBarW / 2);
        }
        this.midBar = new Drawer(this.midBarX, this.midBarY, this.midBarW, this.midBarH);
    }

    public void slide(Graphics paramGraphics, Color paramColor, boolean paramBoolean, double paramDouble1,
            double paramDouble2) {
        updateMidBar();
        if (isPressed(paramDouble1, paramDouble2)) {
            setXSafe(paramDouble1);
            setYSafe(paramDouble2);
        } else {
            setXSafe(getX());
            setYSafe(getY());
        }
        draw(paramGraphics, paramColor, paramBoolean, "oval");
        this.midBar.draw(paramGraphics, Color.gray, true, "rect");
        (new Drawer(getX(), getY(), 1.0D, 1.0D)).draw(paramGraphics, Color.white, paramBoolean, "oval");
    }

    public double getVal(double paramDouble1, double paramDouble2) {
        this.min = paramDouble1;
        this.max = paramDouble2;
        return getVal();
    }

    public double getVal() {
        if (this.horizontal) {
            return map(getX(), getMinX(), getMaxX(), this.min, this.max);
        }
        if (this.vertical) {
            return map(getY(), getMinY(), getMaxY(), this.min, this.max);
        }
        return 0.0D;
    }

    public void setVal(double paramDouble) {
        if (this.horizontal) {
            setXSafe(map(paramDouble, this.min, this.max, getMinX(), getMaxX()));
        } else if (this.vertical) {
            setYSafe(map(paramDouble, this.min, this.max, getMinY(), getMaxY()));
        }
    }

    private double map(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4,
            double paramDouble5) {
        return paramDouble4
                + (paramDouble5 - paramDouble4) / (paramDouble3 - paramDouble2) * (paramDouble1 - paramDouble2);
    }
}
