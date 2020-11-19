public class PIDController {
    public double I, P, D, error, lastError = 0.0, lastIntegral = 0.0;

    private double dT = .1;

    public PIDController(double kP, double kI, double kD, double kdT) {
        P = kP;
        I = kI;
        D = kD;
        dT = kdT;
    }

    public PIDController(double kP, double kI, double kD) {
        P = kP;
        I = kI;
        D = kD;
    }

    public void reset() {
        lastError = 0.0;
        lastIntegral = 0.0;
    }

    public void setP(double p) {
        P = p;
    }

    public void setI(double i) {
        I = i;
    }

    public void setD(double d) {
        D = d;
    }

    public double PIDout(double actual, double desired) {
        error = desired - actual;
        double integral = lastIntegral + (error * dT);
        double derivative = (error - lastError) / dT;
        lastError = error;
        lastIntegral = integral;
        return actual + P * (error) + I * integral + D * derivative;
    }

}
