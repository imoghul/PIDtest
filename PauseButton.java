import Graphics.Button;
import Graphics.ButtonImplementation;
import Graphics.Text;
import java.awt.Color;
import java.awt.Font;

public class PauseButton extends Button implements ButtonImplementation {

    public PauseButton(Button b) {
        super(b);// super(b.getX(), b.getY(), b.getW(), b.getH(), b.getTypeFull(), b.delay);
        this.setLabel("Pause");
        this.getLabel().setColor(Color.white);
        this.getLabel().setFont(new Font("Arial", Font.BOLD, 12));
    }

    @Override
    public void doAction() {
        Main.currentState = Main.State.PAUSED;
    }

    @Override
    public void update() {
        setX(Main.displayW - getW());
        setY(Main.displayH - getH());
    }
}