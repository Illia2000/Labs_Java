package sample;
import static java.lang.Math.*;

public class PowerFunction implements Function {
    public final double r;
    public final Function f;

    public PowerFunction(double k, Function f) {
        this.r = k;
        this.f = f;
    }

    @Override
    public double calculate(double x) {
        return  pow(f.calculate(x),r);
    }

    @Override
    public String print() {
        if(r==0){
            return "1";
        }
        if(r==1){
            return f.print();
        }
        return "(("+f.print()+")^("+String.valueOf(r)+"))";
    }

    @Override
    public Function derivative() {
        return new MultFunction(new ConstFunction(r),new MultFunction(f.derivative(),new PowerFunction(r-1,f)));
    }
}
