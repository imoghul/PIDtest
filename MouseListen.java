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
        Main.mousePressed = true;
    }

    @Override
    public void mouseReleased(MouseEvent arg0) {
        Main.mousePressed = false;
        Main.mouseOccupied = new Button(0.0, 0.0, 0.0, 0.0);
    }

}