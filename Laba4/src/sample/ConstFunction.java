package sample;

public class ConstFunction implements Function {
    private final double value;

    public ConstFunction(double value) {
        this.value = value;
    }

    @Override
    public double calculate(double x) {
        return value;
    }

    @Override
    public String print() {
        if(value<0){
            return "("+String.valueOf(value)+")";
        }
        return String.valueOf(value);
    }

    @Override
    public Function derivative() {
        return ZERO;
    }

    public static final ConstFunction ZERO = new ConstFunction(0);
}

