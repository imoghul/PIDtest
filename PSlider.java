import Graphics.Slider;
import Graphics.SliderImplementation;

public class PSlider extends SliderImplementation {
    public PSlider(Slider s) {
        super(s);
    }

    @Override
    public void doAction() {
        Main.P = getVal();
    }

    @Override
    public void update() {
        center(Main.displayW, Main.displayH, .2);
    }
}