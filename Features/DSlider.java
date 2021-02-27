package Features;
import Graphics.Slider;
import Graphics.SliderImplementation;

public class DSlider extends SliderImplementation {
    public DSlider(Slider s) {
        super(s);
    }

    @Override
    public void doAction() {
        Values.D = getVal();
    }

    @Override
    public void update() {
        center(Values.displayW, Values.displayH, .2);
    }
}