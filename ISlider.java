import Graphics.Slider;
import Graphics.SliderImplementation;

public class ISlider extends SliderImplementation {
    public ISlider(Slider s) {
        super(s);
    }

    @Override
    public void doAction() {
        Values.I = getVal();
    }

    @Override
    public void update() {
        center(Values.displayW, Values.displayH, .2);
    }
}