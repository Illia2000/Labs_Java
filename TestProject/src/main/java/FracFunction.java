public class FracFunction implements Function {
    public final Function a,b;

    public FracFunction(Function a,Function b) {
        this.a = a;
        this.b = b;
    }

    public double calculate(double x) {
        return a.calculate(x)/b.calculate(x);
    }

    public Function derivative() {
        return (new MultFunction(a,new PowerFunction(-1,b))).derivative();
    }
}
