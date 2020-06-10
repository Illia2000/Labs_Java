package sample;
import static java.lang.Math.*;

public class CosFunction implements Function {
    public final Function f;

    public CosFunction(Function f) {
        this.f = f;
    }

    @Override
    public double calculate(double x) {
        return cos(f.calculate(x));
    }

    @Override
    public String print() {
        return "cos("+f.print()+")";
    }

    @Override
    public Function derivative() {
        return new MultFunction(new MultFunction(new ConstFunction(-1),new SinFunction(f)),f.derivative());
    }
}

