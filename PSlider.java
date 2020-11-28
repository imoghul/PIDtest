import Graphics.Slider;

public class PSlider extends Slider {
    public PSlider(Slider s) {
        super(s);
    }

    public void doAction() {
        Main.P = getVal();
        setMinCoor((Main.displayW / 2) - Main.offset);
        setMaxCoor((Main.displayW / 2) + Main.offset);
    }
}