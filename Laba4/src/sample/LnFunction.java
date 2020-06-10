package sample;

import static java.lang.Math.log;

public class LnFunction implements Function {
    private final Function a;
    public LnFunction(Function a) {
        this.a = a;
    }

    @Override
    public double calculate(double x) {
        return log(a.calculate(x));
    }

    @Override
    public String print() {
        return "ln("+a.print()+")";
    }

    @Override
    public Function derivative() {
        return new FracFunction(a.derivative(), a);
    }

}
