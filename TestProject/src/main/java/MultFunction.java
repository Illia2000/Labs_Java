public class MultFunction implements Function {
    public final Function a,b;

    public MultFunction(Function a,Function b) {
        this.a = a;
        this.b = b;
    }

    public double calculate(double x) {
        return a.calculate(x)*b.calculate(x);
    }

    public Function derivative() {
        return new SumFunction(new MultFunction(a,b.derivative()),new MultFunction(a.derivative(),b));
    }
}
