import Graphics.Slider;

public class ISlider extends Slider {
    public ISlider(Slider s) {
        super(s);
    }

    @Override
    public void doAction() {
        Main.I = getVal();
        setMinCoor((Main.displayW / 2) - Main.displayW / 5.0);
        setMaxCoor((Main.displayW / 2) + Main.displayW / 5.0);
    }

    @Override
    public void update() {
        setMinCoor((Main.displayW / 2) - Main.displayW / 5.0);
        setMaxCoor((Main.displayW / 2) + Main.displayW / 5.0);
    }
}