
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.Timer;
import java.awt.event.ActionEvent;

public class Main extends JPanel implements ActionListener {

    public static JFrame window = new JFrame("PID Test");
    static final long serialVersionUID = 536871008L;
    public static TextField textField = new TextField();
    public static Main panel = new Main();
    public static Container c = window.getContentPane(); // public static Dimension screenSize =
                                                         // Toolkit.getDefaultToolkit().getScreenSize();

    public static Timer clock = new Timer(Main.timerSpeed, panel);
    public static Point mousePoint = MouseInfo.getPointerInfo().getLocation();

    public static int displayW = 500;
    public static int displayH = 500;
    public static int timerSpeed = 10;
    public static int speed = 1;

    public static final int CURSORXOFFSET = 43;

    public static final int CURSORYOFFSET = 46;

    public static boolean mousePressed = false;
    public static final int defaultSpeed = 50;
    static double P = 1.0D;
    static double I = 0.0D;
    static double D = 0.0D;
    public static Drawer square = new Drawer(10.0D, 10.0D, 50.0D, 50.0D, P, I, D);
    public static Slider pSlider = new Slider(100.0D, 25.0D, 25.0D, 25.0D, false, true, 200.0D, 300.0D, 1.0E-6D, 1.9D,
            1.0D);
    public static Slider iSlider = new Slider(100.0D, 50.0D, 25.0D, 25.0D, false, true, 200.0D, 300.0D, 0.0D, 100.0D);
    public static Slider dSlider = new Slider(100.0D, 75.0D, 25.0D, 25.0D, false, true, 200.0D, 300.0D, 1.0E-9D,
            0.001D);
    public static Button reset = new Button(0.0D, 0.0D, 50.0D, 50.0D);

    public double offset = 50.0D;

    public void paintComponent(Graphics paramGraphics) {
        this.offset = displayW / 10.0D;
        square.setMinX(0.0D);
        square.setMinY(0.0D);
        square.setMaxX(displayW - square.getW() / 2.0D);
        square.setMaxY(displayH - square.getH() / 2.0D);
        pSlider.setMinX((displayW / 2) - this.offset);
        pSlider.setMaxX((displayW / 2) + this.offset);
        iSlider.setMinX((displayW / 2) - this.offset);
        iSlider.setMaxX((displayW / 2) + this.offset);
        dSlider.setMinX((displayW / 2) - this.offset);
        dSlider.setMaxX((displayW / 2) + this.offset);
        double d1 = ((MouseInfo.getPointerInfo().getLocation()).x - 43);
        double d2 = ((MouseInfo.getPointerInfo().getLocation()).y - 46);
        pSlider.setVal(P);
        iSlider.setVal(I);
        dSlider.setVal(D);

        square.oval(paramGraphics, Color.green, true);
        reset.rect(paramGraphics, Color.red, true);
        pSlider.slide(paramGraphics, Color.blue, true, ((MouseInfo.getPointerInfo().getLocation()).x - 43),
                ((MouseInfo.getPointerInfo().getLocation()).y - 46));
        iSlider.slide(paramGraphics, Color.blue, true, ((MouseInfo.getPointerInfo().getLocation()).x - 43),
                ((MouseInfo.getPointerInfo().getLocation()).y - 46));
        dSlider.slide(paramGraphics, Color.blue, true, ((MouseInfo.getPointerInfo().getLocation()).x - 43),
                ((MouseInfo.getPointerInfo().getLocation()).y - 46));
        paramGraphics.setColor(Color.white);

        paramGraphics.drawString("P: " + P, displayW / 2 + (int) this.offset + 5, 30);
        paramGraphics.drawString("I: " + I, displayW / 2 + (int) this.offset + 5, 55);
        paramGraphics.drawString("D: " + D, displayW / 2 + (int) this.offset + 5, 80);
        paramGraphics.drawString("reset", 5, 30);

        if (reset.isPressed(d1, d2)) {
            square.setX(d1);
            square.setY(d2);
            pSlider.setVal(1.0D);
            iSlider.setVal(iSlider.min);
            dSlider.setVal(dSlider.min);
        }
        P = pSlider.getVal();
        I = iSlider.getVal();
        D = dSlider.getVal();
        square.updateControllers(P, I, D);
        double d3 = ((MouseInfo.getPointerInfo().getLocation()).x - 43);
        double d4 = ((MouseInfo.getPointerInfo().getLocation()).y - 46);
        square.setXPID(d3);
        square.setYPID(d4);
    }

    public void actionPerformed(ActionEvent paramActionEvent) {
        displayW = panel.getWidth();
        displayH = panel.getHeight();
        mousePoint = MouseInfo.getPointerInfo().getLocation();

        repaint();
    }

    public static void main(String[] paramArrayOfString) throws Exception {
        JTextField jTextField = new JTextField();
        JSlider jSlider = new JSlider(0);
        panel.setBackground(Color.black);
        window.setDefaultCloseOperation(3);
        window.add(jTextField);
        panel.addMouseListener(new MouseListen());
        window.setBounds(0, 0, displayW, displayH);
        c.add(panel);
        window.setDefaultCloseOperation(3);
        window.setVisible(true);
        window.setResizable(true);
        clock.start();
    }
}
