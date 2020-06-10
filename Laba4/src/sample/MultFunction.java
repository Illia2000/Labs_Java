package sample;

public class MultFunction implements Function {
    public final Function a,b;

    public MultFunction(Function a,Function b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public double calculate(double x) {
        return a.calculate(x)*b.calculate(x);
    }

    @Override
    public String print() {
        if((a.calculate(28)==0)&&(a.calculate(-5)==0)||(b.calculate(20)==0)&&(b.calculate(-5)==0)){
            return "0";
        }
        return a.print()+"*"+b.print();
    }

    @Override
    public Function derivative() {
        return new SumFunction(new MultFunction(a,b.derivative()),new MultFunction(a.derivative(),b));
    }
}

