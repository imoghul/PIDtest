import Graphics.Slider;

public class DSlider extends Slider {
    public DSlider(Slider s) {
        super(s);
    }

    public void doAction() {
        Main.D = getVal();
        setMinCoor((Main.displayW / 2) - Main.offset);
        setMaxCoor((Main.displayW / 2) + Main.offset);
    }
}