import Graphics.Slider;
import Graphics.SliderImplementation;

public class PSlider extends Slider implements SliderImplementation {
    public PSlider(Slider s) {
        super(s);
    }

    @Override
    public void doAction() {
        Main.P = getVal();
        setMinCoor((Main.displayW / 2) - Main.displayW / 5.0);
        setMaxCoor((Main.displayW / 2) + Main.displayW / 5.0);
    }

    @Override
    public void update() {
        setMinCoor((Main.displayW / 2) - Main.displayW / 5.0);
        setMaxCoor((Main.displayW / 2) + Main.displayW / 5.0);
    }
}