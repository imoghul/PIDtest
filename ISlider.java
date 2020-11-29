import Graphics.Slider;
import Graphics.SliderImplementation;

public class ISlider extends Slider implements SliderImplementation {
    public ISlider(Slider s) {
        super(s);
    }

    @Override
    public void doAction() {
        Main.I = getVal();
    }

    @Override
    public void update() {
        setMinCoor((Main.displayW / 2) - Main.displayW / 5.0);
        setMaxCoor((Main.displayW / 2) + Main.displayW / 5.0);
    }
}