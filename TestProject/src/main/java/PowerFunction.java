import static java.lang.Math.pow;

public class PowerFunction implements Function {
    public final double r;
    public final Function f;

    public PowerFunction(double k, Function f) {
        this.r = k;
        this.f = f;
    }

    public double calculate(double x) {
        return  pow(f.calculate(x),r);
    }

    public Function derivative() {
        return new MultFunction(new ConstFunction(r),new MultFunction(f.derivative(),new PowerFunction(r-1,f)));
    }
}
