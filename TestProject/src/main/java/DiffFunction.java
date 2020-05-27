public class DiffFunction implements Function {
    private final Function a, b;

    public DiffFunction(Function a, Function b) {
        this.a = a;
        this.b = b;
    }

    public double calculate(double x) {
        return a.calculate(x) - b.calculate(x);
    }

    public Function derivative() {
        return new DiffFunction(a.derivative(), b.derivative());
    }

}
