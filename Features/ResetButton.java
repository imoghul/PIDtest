package Features;
import Graphics.Button;
import Graphics.Text;
import Graphics.ButtonImplementation;
import java.awt.Color;
import java.awt.Font;

public class ResetButton extends ButtonImplementation {

    public ResetButton(Button b) {
        super(b);
        this.setLabel("Reset");
        this.getLabel().setColor(Color.white);
        this.getLabel().setFont(new Font("Arial", Font.BOLD, 12));
    }

    @Override
    public void doAction() {
        Values.d.sprite.setX(Values.mouse.getX());
        Values.d.sprite.setY(Values.mouse.getY());
        Values.d.pSlider.setVal(1.0);
        Values.d.iSlider.setVal(0.0);
        Values.d.dSlider.setVal(0.0);
    }

    @Override
    public void update() {

    }
}