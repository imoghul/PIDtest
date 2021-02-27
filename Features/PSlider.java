package Features;
import Graphics.Slider;
import Graphics.SliderImplementation;

public class PSlider extends SliderImplementation {
    public PSlider(Slider s) {
        super(s);
    }

    @Override
    public void doAction() {
        Values.P = getVal();
    }

    @Override
    public void update() {
        center(Values.displayW, Values.displayH, .2);
    }
}