import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

class MouseListen implements MouseListener {
    public void mouseClicked(MouseEvent paramMouseEvent) {
    }

    public void mouseEntered(MouseEvent paramMouseEvent) {
    }

    public void mouseExited(MouseEvent paramMouseEvent) {
    }

    public void mousePressed(MouseEvent paramMouseEvent) {
        Main.mousePressed = true;
    }

    public void mouseReleased(MouseEvent paramMouseEvent) {
        Main.mousePressed = false;
    }
}
