package sample;

public class LinearFunction implements Function {
    public final double k;

    public LinearFunction(double k) {
        this.k = k;
    }

    @Override
    public double calculate(double x) {
        return k * x;
    }

    @Override
    public String print() {
        if(k==1){
            return "x";
        }
        return String.valueOf(k)+"x";
    }

    @Override
    public Function derivative() {
        return new ConstFunction(k);
    }
}
