package Features;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;

import Graphics.Slider;
import Graphics.Button;
import Graphics.Shape;
import Graphics.Text;
import Graphics.Mouse;

public class DemoBase {

    // consists of custom sliders and buttons
    public int colorCounter = 0;
    public Color spriteColor = Color.red;
    // features
    // public Shape sprite = new Shape(10.0, 10.0, 50.0, 50.0, Values.P, Values.I,
    // Values.D, "oval", Values.timerSpeed);

    public PSlider pSlider = new PSlider(new Slider(100.0, 25.0, 25.0, 25.0, false, true, 200.0, 300.0, .000001, 1.9, Values.P, Values.timerSpeed));

    public ISlider iSlider = new ISlider(new Slider(100.0, 55.0, 25.0, 25.0, false, true, 200.0, 300.0, 0, 100, Values.I, Values.timerSpeed));

    public DSlider dSlider = new DSlider(new Slider(100.0, 85.0, 25.0, 25.0, false, true, 200.0, 300.0, -.01, .01, Values.D, Values.timerSpeed));

    public Sprite sprite = new Sprite(new Shape(100.0, 100.0, 50.0, 50.0, Values.P, Values.I, Values.D, "oval", Values.timerSpeed));

    public ResetButton resetButton = new ResetButton(new Button(0.0, 0.0, 50.0, 50.0, Values.timerSpeed));
    public PauseButton pauseButton = new PauseButton(new Button(0.0, 0.0, 50.0, 50.0, Values.timerSpeed));

    public void run(Graphics g, Mouse m) {
        /////////// run sliders and buttons
        sprite.run(g, true, m);
        pauseButton.run(g, Color.blue, new Color(150, 0, 0, 150), true, true, "rect normal", m);
        resetButton.run(g, Color.red, new Color(150, 0, 0, 150), true, true, "rect normal", m);
        pSlider.run(g, Color.blue, new Color(0, 0, 150, 150), true, true, "oval", m);
        iSlider.run(g, Color.blue, new Color(0, 0, 150, 150), true, true, "oval", m);
        dSlider.run(g, Color.blue, new Color(0, 0, 150, 150), true, true, "oval", m);

        // update controllers
        if ((Math.abs(sprite.getX()) > 7500) || (Math.abs(sprite.getY()) > 5000)) {
            resetButton.doAction();
        }

        sprite.updateControllers(Values.P, Values.I, Values.D);
        /////////// draw all the text
        g.setColor(Color.white);
        g.drawString("x: " + sprite.getX(), 0, Values.displayH - 30);
        g.drawString("y: " + sprite.getY(), 0, Values.displayH - 10);
        g.setFont(new Font("Arial", Font.PLAIN, 12));
        g.drawString("P: " + String.format("%.5f", Values.P), (int) ((Values.displayW / 2) + (int) Values.displayW / 5.0 + 5), 30);
        g.drawString("I: " + String.format("%.5f", Values.I), (int) ((Values.displayW / 2) + (int) Values.displayW / 5.0 + 5), 60);
        g.drawString("D: " + String.format("%.5f", Values.D), (int) ((Values.displayW / 2) + (int) Values.displayW / 5.0 + 5), 85);
    }
}