package Features;
import Graphics.Button;
import Graphics.ButtonImplementation;
import Graphics.Text;
import java.awt.Color;
import java.awt.Font;

public class PauseButton extends ButtonImplementation {

    public PauseButton(Button b) {
        super(b);// super(b.getX(), b.getY(), b.getW(), b.getH(), b.getTypeFull(), b.delay);
        this.setLabel("Pause");
        this.getLabel().setColor(Color.white);
        this.getLabel().setFont(new Font("Arial", Font.BOLD, 12));
    }

    @Override
    public void doAction() {
        Values.currentState = Values.State.PAUSED;
    }

    @Override
    public void update() {
        setX(Values.displayW - getW());
        setY(Values.displayH - getH());
    }
}