import Graphics.Button;
import Graphics.Text;
import java.awt.Color;

public class BeginningButton extends Button {

    public BeginningButton(Button b) {
        super(b);// super(b.getX(), b.getY(), b.getW(), b.getH(), b.getTypeFull(), b.delay);
        this.setLabel("Begin");
        this.getLabel().setColor(Color.white);
    }

    @Override
    public void doAction() {
        Main.currentState = Main.State.RUNNING;
    }

    @Override
    public void update() {
        setX(Main.displayW / 2);
        setY(Main.displayH / 2);
        setW(Main.displayW * .2);
        setH(Main.displayH * .2);
    }
}