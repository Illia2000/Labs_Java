public class ConstFunction implements Function {
    public final double value;

    public ConstFunction(double value) {
        this.value = value;
    }

    public double calculate(double x) {
        return value;
    }

    public Function derivative() {
        return ZERO;
    }

    public static final ConstFunction ZERO = new ConstFunction(0);
}
