import Graphics.Area;
import Graphics.PIDController;
import Graphics.Button;
import Graphics.Slider;
import Graphics.Collision;

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
        Main.mouse.setIsPressed(true);// Main.mousePressed = true;

    }

    @Override
    public void mouseReleased(MouseEvent arg0) {
        Main.mouse.setIsPressed(false);// Main.mousePressed = false;
        Main.mouse.clear();
    }

}