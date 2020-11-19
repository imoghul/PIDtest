public class PIDController {
    public double I;
    public double P;
    public double lastError = 0.0D;
    public double D;
    public double error;
    public double lastIntegral = 0.0D;

    private double dT = 0.1D;

    public PIDController(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4) {
        this.P = paramDouble1;
        this.I = paramDouble2;
        this.D = paramDouble3;
        this.dT = paramDouble4;
    }

    public PIDController(double paramDouble1, double paramDouble2, double paramDouble3) {
        this.P = paramDouble1;
        this.I = paramDouble2;
        this.D = paramDouble3;
    }

    public void reset() {
        this.lastError = 0.0D;
        this.lastIntegral = 0.0D;
    }

    public void setP(double paramDouble) {
        this.P = paramDouble;
    }

    public void setI(double paramDouble) {
        this.I = paramDouble;
    }

    public void setD(double paramDouble) {
        this.D = paramDouble;
    }

    public double PIDout(double paramDouble1, double paramDouble2) {
        this.error = paramDouble2 - paramDouble1;
        double d1 = this.lastIntegral + this.error * this.dT;
        double d2 = (this.error - this.lastError) / this.dT;
        this.lastError = this.error;
        this.lastIntegral = d1;
        return paramDouble1 + this.P * this.error + this.I * d1 + this.D * d2;
    }
}
