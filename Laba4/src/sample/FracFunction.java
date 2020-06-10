package sample;

public class FracFunction implements Function {
    public final Function a,b;

    public FracFunction(Function a,Function b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public double calculate(double x) {
        return a.calculate(x)/b.calculate(x);
    }

    @Override
    public String print() {
        return "("+a.print()+")/("+b.print()+")";
    }

    @Override
    public Function derivative() {
        return (new MultFunction(a,new PowerFunction(-1,b))).derivative();
    }
}
