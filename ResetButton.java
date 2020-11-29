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
        Main.d.sprite.setX(Main.mouse.getX());
        Main.d.sprite.setY(Main.mouse.getY());
        Main.d.pSlider.setVal(1.0);
        Main.d.iSlider.setVal(0.0);
        Main.d.dSlider.setVal(0.0);
    }

    @Override
    public void update() {

    }
}