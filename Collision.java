public class Collision {
    public boolean rectCollide(Drawer one, Drawer two) {
        double x = one.getX(), y = one.getY(), w = one.getW(), h = one.getH();
        double x2 = two.getX(), y2 = two.getY(), w2 = two.getW(), h2 = two.getH();
        return (((x2 + w2 >= x) && (x2 <= x + w)) && ((y2 <= y + h) && (y2 + h2 >= y)));
    }

    public boolean ovalCollide(Drawer one, Drawer two) {
        // check if (xcoor,ycoor) is in elipse with (x,y)center and width,w and height,h
        // (Math.pow(((xcoor-x)/(w/2)),2) + Math.pow((ycoor-y)/(h/2),2))<=1
        for (int xcoor = 0; xcoor < Main.displayW; xcoor++) {
            for (int ycoor = 0; ycoor < Main.displayH; ycoor++) {
                if (pointInOval(xcoor, ycoor, one) && pointInOval(xcoor, ycoor, two)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean pointInOval(double xcoor, double ycoor, Drawer oval) {
        double x = oval.getX(), y = oval.getY(), w = oval.getW(), h = oval.getH();
        return (Math.pow(((xcoor - x) / (w / 2)), 2) + Math.pow((ycoor - y) / (h / 2), 2)) <= 1;// (Math.pow(((xcoor-oval.getX())/(ovall.getW()/2)),2)
                                                                                                // +
                                                                                                // Math.pow((ycoor-oval.getY())/(oval.getH()/2),2))<=1;
    }

    public boolean pointInRect(double xcoor, double ycoor, Drawer rect) {
        double x2 = rect.getX(), y2 = rect.getY(), w2 = rect.getW(), h2 = rect.getH();
        return ((xcoor >= x2) && (xcoor <= (x2 + w2)) && (ycoor >= y2) && (ycoor <= (y2 + h2)));
    }

    public boolean ovalRectCollide(Drawer oval, Drawer rect) {
        for (int xcoor = 0; xcoor < Main.displayW; xcoor++) {
            for (int ycoor = 0; ycoor < Main.displayH; ycoor++) {
                if (pointInOval(xcoor, ycoor, oval) && pointInRect(xcoor, ycoor, rect)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean autoIsIn(double x, double y, Drawer one) {
        if (one.getType().equals("rect")) {
            return pointInRect(x, y, one);
        } else if (one.getType().equals("oval")) {
            return pointInOval(x, y, one);
        }
        return false;
    }

    public boolean autoCollide(Drawer one, Drawer two) {
        if (one.getType().equals("rect") && two.getType().equals("rect")) {
            // System.out.println("rect and rect");
            return rectCollide(one, two);
        } else if (one.getType().equals("oval") && two.getType().equals("rect")) {
            // System.out.println("oval and rect");
            return ovalRectCollide(one, two);
        } else if (one.getType().equals("rect") && two.getType().equals("oval")) {
            // System.out.println("rect and oval");
            return ovalRectCollide(two, one);
        } else if (one.getType().equals("oval") && two.getType().equals("oval")) {
            // System.out.println("oval and oval");
            return ovalCollide(one, two);
        }
        return false;
    }
}