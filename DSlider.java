import Graphics.Slider;
import Graphics.SliderImplementation;

public class DSlider extends Slider implements SliderImplementation {
    public DSlider(Slider s) {
        super(s);
    }

    @Override
    public void doAction() {
        Main.D = getVal();
    }

    @Override
    public void update() {
        setMinCoor((Main.displayW / 2) - Main.displayW / 5.0);
        setMaxCoor((Main.displayW / 2) + Main.displayW / 5.0);
    }
}