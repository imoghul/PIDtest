import java.awt.Graphics;
import java.awt.Color;
import Graphics.Slider;
import Graphics.Button;
import Graphics.Shape;
import Graphics.Text;
import Graphics.Mouse;

import java.util.ArrayList;

public class PauseBase {

    // consists of custom sliders and buttons
    public ResumeButton resume = new ResumeButton(new Button(0.0, 0.0, 50.0, 50.0, Main.timerSpeed));

    public void run(Graphics g, Mouse m) {
        resume.run(g, Color.blue, new Color(0, 0, 150, 150), true, true, "oval", m);
    }
}