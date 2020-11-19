import java.awt.Color;
import java.awt.Graphics;

public class Drawer {
    private double x;

    private double y;

    private double w;

    private double h;

    private String type;

    private double minX = Double.MIN_VALUE;

    private double minY = Double.MIN_VALUE;

    private double maxX = Double.MAX_VALUE;

    private double maxY = Double.MAX_VALUE;

    PIDController xcontroller;

    PIDController ycontroller;

    int delay = Main.timerSpeed;

    public Drawer(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4,
            double paramDouble5, double paramDouble6, double paramDouble7) {
        this.x = paramDouble1;
        this.y = paramDouble2;
        this.w = paramDouble3;
        this.h = paramDouble4;
        this.xcontroller = new PIDController(paramDouble5, paramDouble6, paramDouble7, this.delay / 1000.0D);
        this.ycontroller = new PIDController(paramDouble5, paramDouble6, paramDouble7, this.delay / 1000.0D);
    }

    public Drawer(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4) {
        this.x = paramDouble1;
        this.y = paramDouble2;
        this.w = paramDouble3;
        this.h = paramDouble4;
    }

    public Drawer(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4,
            double paramDouble5, double paramDouble6, double paramDouble7, String paramString) {
        this(paramDouble1, paramDouble2, paramDouble3, paramDouble4, paramDouble5, paramDouble6, paramDouble7);
        this.type = paramString;
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public double getW() {
        return this.w;
    }

    public double getH() {
        return this.h;
    }

    public String getType() {
        return this.type;
    }

    public double getMinX() {
        return this.minX;
    }

    public double getMaxX() {
        return this.maxX;
    }

    public double getMinY() {
        return this.minY;
    }

    public double getMaxY() {
        return this.maxY;
    }

    public void setMaxX(double paramDouble) {
        this.maxX = paramDouble;
    }

    public void setMinX(double paramDouble) {
        this.minX = paramDouble;
    }

    public void setMaxY(double paramDouble) {
        this.maxY = paramDouble;
    }

    public void setMinY(double paramDouble) {
        this.minY = paramDouble;
    }

    public void setX(double paramDouble) {
        this.x = paramDouble;
    }

    public void setY(double paramDouble) {
        this.y = paramDouble;
    }

    public void setXSafe(double paramDouble) {
        if (paramDouble >= this.minX && paramDouble <= this.maxX) {
            this.x = paramDouble;
        } else if (paramDouble <= this.minX) {
            this.x = this.minX;
        } else if (paramDouble > this.maxX) {
            this.x = this.maxX;
        }
    }

    public void setYSafe(double paramDouble) {
        if (paramDouble >= this.minY && paramDouble <= this.maxY) {
            this.y = paramDouble;
        } else if (paramDouble <= this.minY) {
            this.y = this.minY;
        } else if (paramDouble > this.maxY) {
            this.y = this.maxY;
        }
    }

    public void updateControllers(double paramDouble1, double paramDouble2, double paramDouble3) {
        this.xcontroller.setP(paramDouble1);
        this.xcontroller.setI(paramDouble2);
        this.xcontroller.setD(paramDouble3);
        this.ycontroller.setP(paramDouble1);
        this.ycontroller.setI(paramDouble2);
        this.ycontroller.setD(paramDouble3);
    }

    public boolean setXPID(double paramDouble) {
        double d = getX();
        if (Math.abs(d - paramDouble) > 0.01D) {
            d = this.xcontroller.PIDout(d, paramDouble);
            setX(d);
            try {
                Thread.sleep(this.delay);
            } catch (InterruptedException interruptedException) {
                Thread.currentThread().interrupt();
            }
            return false;
        }
        this.xcontroller.reset();
        return true;
    }

    public boolean setYPID(double paramDouble) {
        double d = getY();
        if (Math.abs(d - paramDouble) > 0.01D) {
            d = this.ycontroller.PIDout(d, paramDouble);
            setY(d);
            try {
                Thread.sleep(this.delay);
            } catch (InterruptedException interruptedException) {
                Thread.currentThread().interrupt();
            }
            return false;
        }
        this.ycontroller.reset();
        return true;
    }

    public void setW(double paramDouble) {
        this.w = paramDouble;
    }

    public void setH(double paramDouble) {
        this.h = paramDouble;
    }

    public void incrementX(double paramDouble) {
        setX(getX() + paramDouble);
    }

    public void incrementY(double paramDouble) {
        setY(getY() + paramDouble);
    }

    public void incrementW(double paramDouble) {
        this.w += paramDouble;
    }

    public void incrementH(double paramDouble) {
        this.h += paramDouble;
    }

    public void travelVector(int paramInt1, int paramInt2, int paramInt3) {
        System.out.println(
                (int) (paramInt1 / gcd(paramInt1, paramInt2)) + ", " + (int) (paramInt2 / gcd(paramInt1, paramInt2)));
        incrementX((int) (paramInt1 / gcd(paramInt1, paramInt2)));
        incrementY((int) (paramInt2 / gcd(paramInt1, paramInt2)));
    }

    public void rect(Graphics paramGraphics, Color paramColor, boolean paramBoolean) {
        this.type = "rect";
        paramGraphics.setColor(paramColor);
        if (paramBoolean) {
            paramGraphics.fillRect((int) getX(), (int) getY(), (int) getW(), (int) getH());
        } else {
            paramGraphics.drawRect((int) getX(), (int) getY(), (int) getW(), (int) getH());
        }
    }

    public void clear(Graphics paramGraphics) {
        paramGraphics.setColor(Color.black);
    }

    public void oval(Graphics paramGraphics, Color paramColor, boolean paramBoolean) {
        this.type = "oval";
        paramGraphics.setColor(paramColor);
        if (paramBoolean) {
            paramGraphics.fillOval((int) getX() - (int) (getW() / 2.0D), (int) getY() - (int) (getH() / 2.0D),
                    (int) getW(), (int) getH());
        } else {
            paramGraphics.drawOval((int) getX() - (int) (getW() / 2.0D), (int) getY() - (int) (getH() / 2.0D),
                    (int) getW(), (int) getH());
        }
    }

    public void drawAuto(Graphics paramGraphics, Color paramColor, boolean paramBoolean) {
        if (this.type.equals("rect")) {
            rect(paramGraphics, paramColor, paramBoolean);
        } else if (this.type.equals("oval")) {
            oval(paramGraphics, paramColor, paramBoolean);
        }
    }

    public void draw(Graphics paramGraphics, Color paramColor, boolean paramBoolean, String paramString) {
        this.type = paramString;
        if (this.type.equals("rect")) {
            rect(paramGraphics, paramColor, paramBoolean);
        } else if (this.type.equals("oval")) {
            oval(paramGraphics, paramColor, paramBoolean);
        }
    }

    private static int gcd(int paramInt1, int paramInt2) {
        if (paramInt2 == 0)
            return paramInt1;
        return gcd(paramInt2, paramInt1 % paramInt2);
    }
}
