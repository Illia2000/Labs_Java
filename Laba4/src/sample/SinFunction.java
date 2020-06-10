package sample;
import static java.lang.Math.*;

public class SinFunction implements Function {
    public final Function f;

    public SinFunction(Function f) {
        this.f = f;
    }

    @Override
    public double calculate(double x) {
        return sin(f.calculate(x));
    }

    @Override
    public String print() {
        return "sin("+f.print()+")";
    }

    @Override
    public Function derivative() {
        return new MultFunction(new CosFunction(f),f.derivative());
    }
}
