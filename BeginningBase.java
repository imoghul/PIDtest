import java.awt.Graphics;
import java.awt.Color;
import Graphics.Slider;
import Graphics.Button;
import Graphics.Shape;
import Graphics.Text;
import Graphics.Mouse;

import java.util.ArrayList;

public class BeginningBase {
    public BeginningButton beginButton = new BeginningButton(
            new Button(Main.displayW / 2, Main.displayH / 2, Main.displayW * .2, Main.displayH * .2, Main.timerSpeed));

    public void run(Graphics g, Mouse m) {
        beginButton.run(g, Color.blue, new Color(0, 0, 150, 150), true, true, "rect centered", m);
    }
}