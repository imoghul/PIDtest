import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;
import javax.swing.event.*;
import java.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;
import java.util.Scanner;

//extends JPanel implements ActionListener
public class Main extends JPanel implements ActionListener {
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
	public static int displayW = 500, displayH = 500, timerSpeed = 10, speed = 1; // full screen:
	public static final int CURSORXOFFSET = 43;
	public static final int CURSORYOFFSET = 46;
	public static boolean mousePressed = false;
	public static Button mouseOccupied = new Button(0.0, 0.0, 0.0, 0.0);;
	public static final int defaultSpeed = 50;
	// displayW=1389,displayH=855
	// Objects

	static double P = 1.0;// .1;// 1.1;//.3;
	static double I = 0.0;// 3;// 30;//30;
	static double D = 0.0;// 0.00001;// -.001;//.001;
	public static Drawer square = new Drawer(10.0, 10.0, 50.0, 50.0, P, I, D);
	public static Slider pSlider = new Slider(100.0, 25.0, 25.0, 25.0, false, true, 200.0, 300.0, .000001, 1.9, Main.P);
	public static Slider iSlider = new Slider(100.0, 50.0, 25.0, 25.0, false, true, 200.0, 300.0, -1, 100, Main.I);
	public static Slider dSlider = new Slider(100.0, 75.0, 25.0, 25.0, false, true, 200.0, 300.0, -.001, .001, Main.D);
	public static Button reset = new Button(0.0, 0.0, 50.0, 50.0);

	public double offset = 50;

	public void paintComponent(Graphics g) {
		System.out.println(Main.mouseOccupied);
		// update stuff
		offset = Main.displayW / 5.0;
		Main.square.setMinX(0);
		Main.square.setMinY(0);
		Main.square.setMaxX(Main.displayW - Main.square.getW() / 2.0);
		Main.square.setMaxY(Main.displayH - Main.square.getH() / 2.0);
		Main.pSlider.setMinX((Main.displayW / 2) - offset);
		Main.pSlider.setMaxX((Main.displayW / 2) + offset);
		Main.iSlider.setMinX((Main.displayW / 2) - offset);
		Main.iSlider.setMaxX((Main.displayW / 2) + offset);
		Main.dSlider.setMinX((Main.displayW / 2) - offset);
		Main.dSlider.setMaxX((Main.displayW / 2) + offset);
		double mouseX = MouseInfo.getPointerInfo().getLocation().x - CURSORXOFFSET;
		double mouseY = MouseInfo.getPointerInfo().getLocation().y - CURSORYOFFSET;
		Main.pSlider.setVal(Main.P);
		Main.iSlider.setVal(Main.I);
		Main.dSlider.setVal(Main.D);
		// draw objects and strings
		Main.square.oval(g, Color.green, true);
		if (!Main.reset.isPressed(mouseX, mouseY)) {
			Main.reset.rect(g, Color.red, true);
		} else {
			Main.reset.rect(g, new Color(150, 0, 0), true);
		}
		Main.pSlider.slide(g, Color.blue, true, mouseX, mouseY);
		Main.iSlider.slide(g, Color.blue, true, mouseX, mouseY);
		Main.dSlider.slide(g, Color.blue, true, mouseX, mouseY);
		g.setColor(Color.white);
		// g.drawString("x: " + Main.square.getX(), 0, 20);
		// g.drawString("y: " + Main.square.getY(), 0, 40);
		g.drawString("P: " + String.format("%.5f", Main.P), (Main.displayW / 2) + (int) offset + 5, 30);
		g.drawString("I: " + String.format("%.5f", Main.I), (Main.displayW / 2) + (int) offset + 5, 55);
		g.drawString("D: " + String.format("%.5f", Main.D), (Main.displayW / 2) + (int) offset + 5, 80);
		g.drawString("reset", 5, 30);
		// pid loop
		if (Main.reset.isPressed(mouseX, mouseY)) {
			Main.square.setX(mouseX);
			Main.square.setY(mouseY);
			Main.pSlider.setVal(1.0);
			Main.iSlider.setVal(0.0);
			Main.dSlider.setVal(0.0);
		}
		Main.P = pSlider.getVal();
		Main.I = iSlider.getVal();
		Main.D = dSlider.getVal();
		Main.square.updateControllers(Main.P, Main.I, Main.D);
		double desiredX = MouseInfo.getPointerInfo().getLocation().x - CURSORXOFFSET;// 120.0;
		double desiredY = MouseInfo.getPointerInfo().getLocation().y - CURSORYOFFSET;// 120.0;
		Main.square.setXPID(desiredX);
		Main.square.setYPID(desiredY);
		/*
		 * try { Thread.sleep(100); } catch (InterruptedException ie) {
		 * Thread.currentThread().interrupt(); }
		 */
	}

	public void actionPerformed(ActionEvent e) {
		// double desiredX, desiredY;
		// System.out.println(
		// MouseInfo.getPointerInfo().getLocation().x + ", " +
		// MouseInfo.getPointerInfo().getLocation().y);
		Main.displayW = Main.panel.getWidth();
		Main.displayH = Main.panel.getHeight();
		Main.mousePoint = MouseInfo.getPointerInfo().getLocation();
		// System.out.println(Main.displayW + ", " + Main.displayH);
		repaint();
	}

	public static void main(String[] argv) throws Exception {
		JTextField textField = new JTextField();
		JSlider PGain = new JSlider(JSlider.HORIZONTAL);
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
}
