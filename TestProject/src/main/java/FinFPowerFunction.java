import static java.lang.Math.pow;
public class FinFPowerFunction implements Function {
    public final Function f;
    public final Function power;
    public FinFPowerFunction(Function f, Function power) {
        this.f = f;
        this.power = power;
    }

    public double calculate(double x) {
        return pow(f.calculate(x),power.calculate(x));
    }

    public Function derivative() {
        return new MultFunction(new FinFPowerFunction(f,power),(new MultFunction(power,new LnFunction(f))).derivative());
    }
}
