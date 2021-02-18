import Graphics.Slider;
import Graphics.SliderImplementation;

public class ISlider extends SliderImplementation {
    public ISlider(Slider s) {
        super(s);
    }

    @Override
    public void doAction() {
        Main.I = getVal();
    }

    @Override
    public void update() {
        center(Main.displayW, Main.displayH, .2);
    }
}