import static java.lang.Math.log;
public class LnFunction implements Function {
    private final Function a;
    public LnFunction(Function a) {
        this.a = a;
    }

    public double calculate(double x) {
        return log(a.calculate(x));
    }

    public Function derivative() {
        return new FracFunction(a.derivative(), a);
    }

}
