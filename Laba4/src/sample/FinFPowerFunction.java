package sample;

import static java.lang.Math.pow;

public class FinFPowerFunction implements Function {
    private final Function f;
    private final Function power;
    public FinFPowerFunction(Function f, Function power) {
        this.f = f;
        this.power = power;
    }

    @Override
    public double calculate(double x) {
        return pow(f.calculate(x),power.calculate(x));
    }

    @Override
    public String print() {
        return "(("+f.print()+")^("+power.print()+"))";
    }

    @Override
    public Function derivative() {
        return new MultFunction(new FinFPowerFunction(f,power),(new MultFunction(power,new LnFunction(f))).derivative());
    }

}
