public class LinearFunction implements Function {
    public final double k;

    public LinearFunction(double k) {
        this.k = k;
    }

    public double calculate(double x) {
        return k * x;
    }

    public Function derivative() {
        return new ConstFunction(k);
    }
}
