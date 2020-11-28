import Graphics.Shape;
import Graphics.PIDController;
import Graphics.Button;
import Graphics.Slider;
import Graphics.Collision;
import Graphics.Mouse;
import Graphics.Text;

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
	public static final int defaultSpeed = 50;
	// displayW=1389,displayH=855
	// Objects
	public static Collision checker = new Collision();
	static double P = 1.0;// .1;// 1.1;//.3;
	static double I = 0.0;// 3;// 30;//30;
	static double D = 0.0;// 0.00001;// -.001;//.001;
	public static Shape sprite = new Shape(10.0, 10.0, 50.0, 50.0, P, I, D, "oval", Main.timerSpeed);

	public static FeatureBase f = new FeatureBase();
	public static Color spriteColor = Color.red;
	public static double offset = 50.0;
	public static int colorCounter = 0;
	public static Mouse mouse = new Mouse(Main.timerSpeed);

	public void paintComponent(Graphics g) {
		Main.updateMouse();
		Main.updateValues();
		Main.drawStuff(g);
		Main.PIDLoops();
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

	public static void updateValues() {
		// update bounds
		Main.sprite.setMinX(0);
		Main.sprite.setMinY(0);
		Main.sprite.setMaxX(Main.displayW - Main.sprite.getW() / 2.0);
		Main.sprite.setMaxY(Main.displayH - Main.sprite.getH() / 2.0);
		// update slider centering offset
		Main.offset = Main.displayW / 5.0;
		// update checker's values
		Main.checker.displayH = Main.displayH;
		Main.checker.displayW = Main.displayW;
		// increment color
		Main.colorCounter++;
	}

	public static void drawStuff(Graphics g) {
		// draw the sprite
		if (Main.sprite.xcontroller.hasReached(Main.sprite.getX(), Main.mouse.getX())
				&& Main.sprite.ycontroller.hasReached(Main.sprite.getY(), Main.mouse.getY())) {
			Main.spriteColor = new Color(0, 255, 0);
		} else {
			Main.spriteColor = new Color(255, 0, 0, ((Main.colorCounter % 20) + 5) * 10);// Color.RED;
		}
		Main.sprite.draw(g, Main.spriteColor, true);
		// run all features
		f.run(g, Main.mouse);
		// draw all the text
		g.setColor(Color.white);
		// g.drawString("x: " + Main.sprite.getX(), 0, 20);
		// g.drawString("y: " + Main.sprite.getY(), 0, 40);
		g.drawString("P: " + String.format("%.5f", Main.P), (Main.displayW / 2) + (int) offset + 5, 30);
		g.drawString("I: " + String.format("%.5f", Main.I), (Main.displayW / 2) + (int) offset + 5, 55);
		g.drawString("D: " + String.format("%.5f", Main.D), (Main.displayW / 2) + (int) offset + 5, 80);
		g.drawString("reset", 5, 30);
	}

	public static void PIDLoops() {
		// Update controllers
		Main.sprite.updateControllers(Main.P, Main.I, Main.D);
		// Set Values
		Main.sprite.setXPID(Main.mouse.getX());
		Main.sprite.setYPID(Main.mouse.getY());
	}
}
