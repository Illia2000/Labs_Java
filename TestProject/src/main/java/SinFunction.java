import static java.lang.Math.sin;

public class SinFunction implements Function {
    public final Function f;

    public SinFunction(Function f) {
        this.f = f;
    }

    public double calculate(double x) {
        return sin(f.calculate(x));
    }

    public Function derivative() {
        return new MultFunction(new CosFunction(f),f.derivative());
    }
}
