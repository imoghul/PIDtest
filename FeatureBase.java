import java.awt.Graphics;
import java.awt.Color;
import Graphics.Slider;
import Graphics.Button;
import Graphics.Shape;
import Graphics.Text;
import Graphics.Mouse;

import java.util.ArrayList;

public class FeatureBase {

    // consists of custom sliders and buttons

    public PSlider pSlider = new PSlider(
            new Slider(100.0, 25.0, 25.0, 25.0, false, true, 200.0, 300.0, .000001, 1.9, Main.P, Main.timerSpeed));

    public ISlider iSlider = new ISlider(
            new Slider(100.0, 50.0, 25.0, 25.0, false, true, 200.0, 300.0, 0, 100, Main.I, Main.timerSpeed));

    public DSlider dSlider = new DSlider(
            new Slider(100.0, 75.0, 25.0, 25.0, false, true, 200.0, 300.0, -.01, .01, Main.D, Main.timerSpeed));

    public ResetButton resetButton = new ResetButton(new Button(0.0, 0.0, 50.0, 50.0, Main.timerSpeed));

    public void run(Graphics g, Mouse m) {
        resetButton.run(g, Color.red, new Color(150, 0, 0), true, true, "rect normal", m);
        pSlider.run(g, Color.blue, new Color(0, 0, 130), true, true, "oval", m);
        iSlider.run(g, Color.blue, new Color(0, 0, 130), true, true, "oval", m);
        dSlider.run(g, Color.blue, new Color(0, 0, 130), true, true, "oval", m);
    }
}