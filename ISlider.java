import Graphics.Slider;

public class ISlider extends Slider {
    public ISlider(Slider s) {
        super(s);
    }

    @Override
    public void doAction() {
        Main.I = getVal();
        setMinCoor((Main.displayW / 2) - Main.offset);
        setMaxCoor((Main.displayW / 2) + Main.offset);
    }
}