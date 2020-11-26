import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class MouseListen implements MouseListener {

    @Override
    public void mouseClicked(MouseEvent arg0) {
    }

    @Override
    public void mouseEntered(MouseEvent arg0) {
    }

    @Override
    public void mouseExited(MouseEvent arg0) {
    }

    @Override
    public void mousePressed(MouseEvent arg0) {
        if (!Main.mousePressed) {
            Main.mouseXOrig = Main.mouseX;// MouseInfo.getPointerInfo().getLocation().x;
            Main.mouseYOrig = Main.mouseY;// MouseInfo.getPointerInfo().getLocation().y;
        }
        if (!Main.mouseJustPressed) {
            Main.mouseJustPressed = true;
        } else {
            Main.mouseJustPressed = false;
        }
        Main.mousePressed = true;
    }

    @Override
    public void mouseReleased(MouseEvent arg0) {
        Main.mousePressed = false;
        Main.mouseJustPressed = false;
        Main.mouseOccupied = new Button(0.0, 0.0, 0.0, 0.0);
    }

}