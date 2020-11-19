public class Collision {
    public boolean rectCollide(Drawer paramDrawer1, Drawer paramDrawer2) {
        double d1 = paramDrawer1.getX(), d2 = paramDrawer1.getY(), d3 = paramDrawer1.getW(), d4 = paramDrawer1.getH();
        double d5 = paramDrawer2.getX(), d6 = paramDrawer2.getY(), d7 = paramDrawer2.getW(), d8 = paramDrawer2.getH();
        return (d5 + d7 >= d1 && d5 <= d1 + d3 && d6 <= d2 + d4 && d6 + d8 >= d2);
    }

    public boolean ovalCollide(Drawer paramDrawer1, Drawer paramDrawer2) {
        for (byte b = 0; b < Main.displayW; b++) {
            for (byte b1 = 0; b1 < Main.displayH; b1++) {
                if (pointInOval(b, b1, paramDrawer1) && pointInOval(b, b1, paramDrawer2))
                    return true;
            }
        }
        return false;
    }

    public boolean pointInOval(double paramDouble1, double paramDouble2, Drawer paramDrawer) {
        double d1 = paramDrawer.getX(), d2 = paramDrawer.getY(), d3 = paramDrawer.getW(), d4 = paramDrawer.getH();
        return (Math.pow((paramDouble1 - d1) / d3 / 2.0D, 2.0D)
                + Math.pow((paramDouble2 - d2) / d4 / 2.0D, 2.0D) <= 1.0D);
    }

    public boolean pointInRect(double paramDouble1, double paramDouble2, Drawer paramDrawer) {
        double d1 = paramDrawer.getX(), d2 = paramDrawer.getY(), d3 = paramDrawer.getW(), d4 = paramDrawer.getH();
        return (paramDouble1 >= d1 && paramDouble1 <= d1 + d3 && paramDouble2 >= d2 && paramDouble2 <= d2 + d4);
    }

    public boolean ovalRectCollide(Drawer paramDrawer1, Drawer paramDrawer2) {
        for (byte b = 0; b < Main.displayW; b++) {
            for (byte b1 = 0; b1 < Main.displayH; b1++) {
                if (pointInOval(b, b1, paramDrawer1) && pointInRect(b, b1, paramDrawer2))
                    return true;
            }
        }
        return false;
    }

    public boolean autoIsIn(double paramDouble1, double paramDouble2, Drawer paramDrawer) {
        if (paramDrawer.getType().equals("rect"))
            return pointInRect(paramDouble1, paramDouble2, paramDrawer);
        if (paramDrawer.getType().equals("oval"))
            return pointInOval(paramDouble1, paramDouble2, paramDrawer);
        return false;
    }

    public boolean autoCollide(Drawer paramDrawer1, Drawer paramDrawer2) {
        if (paramDrawer1.getType().equals("rect") && paramDrawer2.getType().equals("rect"))
            return rectCollide(paramDrawer1, paramDrawer2);
        if (paramDrawer1.getType().equals("oval") && paramDrawer2.getType().equals("rect"))
            return ovalRectCollide(paramDrawer1, paramDrawer2);
        if (paramDrawer1.getType().equals("rect") && paramDrawer2.getType().equals("oval"))
            return ovalRectCollide(paramDrawer2, paramDrawer1);
        if (paramDrawer1.getType().equals("oval") && paramDrawer2.getType().equals("oval"))
            return ovalCollide(paramDrawer1, paramDrawer2);
        return false;
    }
}
