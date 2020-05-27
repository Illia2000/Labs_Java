import static java.lang.Math.cos;

public class CosFunction implements Function {
    public final Function f;

    public CosFunction(Function f) {
        this.f = f;
    }

    public double calculate(double x) {
        return cos(f.calculate(x));
    }

    public Function derivative() {
        return new MultFunction(new DiffFunction(new ConstFunction(0),new SinFunction(f)),f.derivative());
    }
}
