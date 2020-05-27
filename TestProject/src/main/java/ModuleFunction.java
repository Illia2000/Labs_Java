import static java.lang.Math.abs;

public class ModuleFunction implements Function {
    private final Function a;

    public ModuleFunction(Function a) {
        this.a = a;
    }

    public double calculate(double x) {
        return abs(a.calculate(x));
    }

    public Function derivative() {
        return new MultFunction(a.derivative(),new FracFunction(a, new ModuleFunction(a)));
    }

}
