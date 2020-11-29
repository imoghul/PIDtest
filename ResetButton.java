import Graphics.Button;
import Graphics.Text;

public class ResetButton extends Button {

    public ResetButton(Button b) {
        super(b);// super(b.getX(), b.getY(), b.getW(), b.getH(), b.getTypeFull(), b.delay);
        this.setLabel("Reset");
    }

    @Override
    public void doAction() {
        Main.sprite.setX(Main.mouse.getX());
        Main.sprite.setY(Main.mouse.getY());
        Main.f.pSlider.setVal(1.0);
        Main.f.iSlider.setVal(0.0);
        Main.f.dSlider.setVal(0.0);
    }
}