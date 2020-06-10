package sample;

import static java.lang.Math.abs;

public class ModuleFunction implements Function {
    private final Function a;

    public ModuleFunction(Function a) {
        this.a = a;
    }

    @Override
    public double calculate(double x) {
        return abs(a.calculate(x));
    }

    @Override
    public String print() {
        return "|"+a.print()+"|";
    }

    @Override
    public Function derivative() {
        return new MultFunction(a.derivative(),new FracFunction(a, new ModuleFunction(a)));
    }

}
