import Features.Values;
import Graphics.Mouse;
import java.awt.*;
import java.awt.event.*;
import java.awt.font.*;
import java.util.Random;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JPanel implements ActionListener {

    // Graphical constants
    public static JFrame window = new JFrame("PID Test");
    public static Main panel = new Main();
    public static Container c = window.getContentPane();
    public static Timer clock = new Timer(Values.timerSpeed, panel);
    // Fields

    public void paintComponent(Graphics g) {
        Main.update();

        switch (Values.currentState) {
            case BEGINNING:
                Values.b.run(g, Values.mouse);
                break;

            case RUNNING:
                Values.d.run(g, Values.mouse);
                break;

            case PAUSED:
                Values.p.run(g, Values.mouse);
                break;
        }

        // delay
        // try {
        //     Thread.sleep(Values.timerSpeed);
        // } catch (InterruptedException ie) {
        //     Thread.currentThread().interrupt();
        // }
    }

    public void actionPerformed(ActionEvent e) {
        repaint();
    }

    public static void main(String[] argv) throws Exception {
        Values.mouse.clear();
        Main.panel.setBackground(Color.black);
        Main.window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Main.panel.addMouseListener(new MouseListen());
        Main.window.setBounds(0, 0, Values.displayW, Values.displayH);
        Main.c.add(panel);
        Main.window.setVisible(true);
        Main.window.setResizable(true);
        Main.clock.start();
    }

    public static void update() {
        Values.displayW = Main.panel.getWidth();
        Values.displayH = Main.panel.getHeight();
        Values.mouse.update(MouseInfo.getPointerInfo().getLocation().x - Main.panel.getLocationOnScreen().x, MouseInfo.getPointerInfo().getLocation().y - Main.panel.getLocationOnScreen().y);
    }

}
