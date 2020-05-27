public class SumFunction implements Function {
    private final Function a, b;

    public SumFunction(Function a, Function b) {
        this.a = a;
        this.b = b;
    }

    public double calculate(double x) {
        return a.calculate(x) + b.calculate(x);
    }

    public Function derivative() {
        return new SumFunction(a.derivative(), b.derivative());
    }

}
