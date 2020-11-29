
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
import java.util.concurrent.TimeUnit;
import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;

//extends JPanel implements ActionListener
public class Main extends JPanel implements ActionListener {
	enum State {
		BEGINNING, RUNNING, PAUSED
	}

	// Graphical constants
	static final long serialVersionUID = 536871008;
	public static JFrame window = new JFrame("PID Test");
	public static TextField textField = new TextField();
	public static Main panel = new Main();
	public static Container c = window.getContentPane();
	public static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	public static Timer clock = new Timer(Main.timerSpeed, panel);
	public static Point mousePoint = MouseInfo.getPointerInfo().getLocation();
	// Fields
	public static int displayW = 500, displayH = 500, timerSpeed = 15, speed = 1; // full screen:
	public static double P = 1.0;// .1;// 1.1;//.3;
	public static double I = 0.0;// 3;// 30;//30;
	public static double D = 0.0;// 0.00001;// -.001;//.001;
	public static State currentState = State.BEGINNING;
	// Objects
	public static BeginningBase b = new BeginningBase();
	public static DemoBase d = new DemoBase();
	public static PauseBase p = new PauseBase();
	public static Mouse mouse = new Mouse(Main.timerSpeed);

	public void paintComponent(Graphics g) {
		Main.updateMouse();

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
		Main.displayW = Main.panel.getWidth();
		Main.displayH = Main.panel.getHeight();
		repaint();
	}

	public static void main(String[] argv) throws Exception {
		JTextField textField = new JTextField();
		Main.mouse.clear();
		Main.panel.setBackground(Color.black);
		Main.window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Main.window.add(textField);
		Main.panel.addMouseListener(new MouseListen());
		Main.window.setBounds(0, 0, displayW, displayH);
		Main.c.add(panel);
		Main.window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Main.window.setVisible(true);
		Main.window.setResizable(true);
		Main.clock.start();
	}

	public static void updateMouse() {
		Main.mouse.setX(MouseInfo.getPointerInfo().getLocation().x - Main.panel.getLocationOnScreen().x);
		Main.mouse.setY(MouseInfo.getPointerInfo().getLocation().y - Main.panel.getLocationOnScreen().y);
		Main.mouse.update(Main.mouse.getX(), Main.mouse.getY());
	}

}
