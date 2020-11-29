import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;

import Graphics.Slider;
import Graphics.Button;
import Graphics.Shape;
import Graphics.Text;
import Graphics.Mouse;

import java.util.ArrayList;

public class DemoBase {

        // consists of custom sliders and buttons
        public int colorCounter = 0;
        public Color spriteColor = Color.red;
        public Shape sprite = new Shape(10.0, 10.0, 50.0, 50.0, Main.P, Main.I, Main.D, "oval", Main.timerSpeed);

        public PSlider pSlider = new PSlider(new Slider(100.0, 25.0, 25.0, 25.0, false, true, 200.0, 300.0, .000001,
                        1.9, Main.P, Main.timerSpeed));

        public ISlider iSlider = new ISlider(new Slider(100.0, 55.0, 25.0, 25.0, false, true, 200.0, 300.0, 0, 100,
                        Main.I, Main.timerSpeed));

        public DSlider dSlider = new DSlider(new Slider(100.0, 80.0, 25.0, 25.0, false, true, 200.0, 300.0, -.01, .01,
                        Main.D, Main.timerSpeed));

        public ResetButton resetButton = new ResetButton(new Button(0.0, 0.0, 50.0, 50.0, Main.timerSpeed));
        public PauseButton pauseButton = new PauseButton(new Button(0.0, 0.0, 50.0, 50.0, Main.timerSpeed));

        public void run(Graphics g, Mouse m) {
                ///////////// update bounds
                sprite.setMinX(0);
                sprite.setMinY(0);
                sprite.setMaxX(Main.displayW - sprite.getW() / 2.0);
                sprite.setMaxY(Main.displayH - sprite.getH() / 2.0);
                /////////// draw sprite
                colorCounter++;
                if (sprite.xcontroller.hasReached(sprite.getX(), m.getX())
                                && sprite.ycontroller.hasReached(sprite.getY(), m.getY())) {
                        spriteColor = new Color(0, 255, 0);
                } else {
                        spriteColor = new Color(255, 0, 0, ((colorCounter % 20) + 5) * 10);// Color.RED;
                }
                sprite.draw(g, spriteColor, true);
                // Set Values
                sprite.setXPID(Main.mouse.getX());
                sprite.setYPID(Main.mouse.getY());
                /////////// run sliders and buttons
                pauseButton.run(g, Color.blue, new Color(150, 0, 0, 150), true, true, "rect normal", m);
                resetButton.run(g, Color.red, new Color(150, 0, 0, 150), true, true, "rect normal", m);
                pSlider.run(g, Color.blue, new Color(0, 0, 150, 150), true, true, "oval", m);
                iSlider.run(g, Color.blue, new Color(0, 0, 150, 150), true, true, "oval", m);
                dSlider.run(g, Color.blue, new Color(0, 0, 150, 150), true, true, "oval", m);
                // update controllers
                sprite.updateControllers(Main.P, Main.I, Main.D);
                /////////// draw all the text
                g.setColor(Color.white);
                // g.drawString("x: " + Main.sprite.getX(), 0, 20);
                // g.drawString("y: " + Main.sprite.getY(), 0, 40);
                g.setFont(new Font("Arial", Font.PLAIN, 12));
                g.drawString("P: " + String.format("%.5f", Main.P),
                                (int) ((Main.displayW / 2) + (int) Main.displayW / 5.0 + 5), 30);
                g.drawString("I: " + String.format("%.5f", Main.I),
                                (int) ((Main.displayW / 2) + (int) Main.displayW / 5.0 + 5), 55);
                g.drawString("D: " + String.format("%.5f", Main.D),
                                (int) ((Main.displayW / 2) + (int) Main.displayW / 5.0 + 5), 80);
        }
}