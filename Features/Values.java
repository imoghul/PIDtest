package Features;
import Graphics.Mouse;

public class Values {

    public enum State {
        BEGINNING, RUNNING, PAUSED
    }

    public static int displayW = 1500, displayH = 1000, timerSpeed = 15;
    // Specific Fields
    public static double P = 1.0;
    public static double I = 0.0;
    public static double D = 0.0;
    public static State currentState = State.BEGINNING;
    // Objects
    public static BeginningBase b = new BeginningBase();
    public static DemoBase d = new DemoBase();
    public static PauseBase p = new PauseBase();
    public static Mouse mouse = new Mouse(Values.timerSpeed);

}