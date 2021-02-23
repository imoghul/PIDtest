import Graphics.Button;
import Graphics.Text;
import Graphics.ButtonImplementation;
import java.awt.Color;
import java.awt.Font;

public class ResumeButton extends ButtonImplementation {

    public ResumeButton(Button b) {
        super(b);// super(b.getX(), b.getY(), b.getW(), b.getH(), b.getTypeFull(), b.delay);
        this.setLabel("Resume");
        this.getLabel().setColor(Color.white);
        this.getLabel().setFont(new Font("Arial", Font.BOLD, 36));
    }

    @Override
    public void doAction() {
        Values.currentState = Values.State.RUNNING;
    }

    @Override
    public void update() {
        center(Values.displayW, Values.displayH);
        setW(Values.displayW * .2);
        setH(Values.displayH * .2);
    }
}