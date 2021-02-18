import Graphics.Mouse;
import java.awt.*;
import java.awt.event.*;
import java.awt.font.*;
import java.util.Random;
import javax.swing.*;
import javax.swing.event.*;
import java.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JPanel implements ActionListener {

    enum State {
        BEGINNING, RUNNING, PAUSED
    }

    // Graphical constants
    public static JFrame window = new JFrame("PID Test");
    public static Main panel = new Main();
    public static Container c = window.getContentPane();
    public static Timer clock = new Timer(Main.timerSpeed, panel);
    // Fields
    public static int displayW = 1500, displayH = 1000, timerSpeed = 15;
    // Specific Fields
    public static double P = 1.0;
    public static double I = 0.0;
    public static double D = 0.0;
    public static State currentState = State.BEGINNING;
    // Objects
    public static BeginningBase b = new BeginningBase();
    public static DemoBase d = new DemoBase();
    public static PauseBase p = new PauseBase();
    public static Mouse mouse = new Mouse(Main.timerSpeed);

    public void paintComponent(Graphics g) {
        Main.update();

        switch (Main.currentState) {
        case BEGINNING:
            Main.b.run(g, Main.mouse);
            break;

        case RUNNING:
            Main.d.run(g, Main.mouse);
            break;

        case PAUSED:
            Main.p.run(g, Main.mouse);
            break;
        }

        // delay
        try {
            Thread.sleep(Main.timerSpeed);
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
        }
    }

    public void actionPerformed(ActionEvent e) {
        repaint();
    }

    public static void main(String[] argv) throws Exception {
        Main.mouse.clear();
        Main.panel.setBackground(Color.black);
        Main.window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Main.panel.addMouseListener(new MouseListen());
        Main.window.setBounds(0, 0, displayW, displayH);
        Main.c.add(panel);
        Main.window.setVisible(true);
        Main.window.setResizable(true);
        Main.clock.start();
    }

    public static void update() {
        Main.displayW = Main.panel.getWidth();
        Main.displayH = Main.panel.getHeight();
        Main.mouse.update(MouseInfo.getPointerInfo().getLocation().x - Main.panel.getLocationOnScreen().x,
                MouseInfo.getPointerInfo().getLocation().y - Main.panel.getLocationOnScreen().y);
    }

}
