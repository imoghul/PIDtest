import Graphics.Text;
import Graphics.ButtonImplementation;
import Graphics.Button;
import java.awt.Color;
import java.awt.Font;

public class BeginningButton extends ButtonImplementation {

    public BeginningButton(Button b) {
        super(b);// super(b.getX(), b.getY(), b.getW(), b.getH(), b.getTypeFull(), b.delay);
        this.setLabel("Begin");
        this.getLabel().setColor(Color.white);
        this.getLabel().setFont(new Font("Arial", Font.BOLD, 36));
    }

    @Override
    public void doAction() {
        Main.currentState = Main.State.RUNNING;
    }

    @Override
    public void update() {
        center(Main.displayW, Main.displayH);
        setW(Main.displayW * .2);
        setH(Main.displayH * .2);
    }
}